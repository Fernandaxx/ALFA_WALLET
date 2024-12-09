package wallet.dao.impl;

import java.sql.*;
import java.time.LocalDateTime;

import wallet.model.entity.ActivoCripto;
import wallet.model.entity.ActivoFiat;
import wallet.model.entity.Compra;
import wallet.model.entity.Criptomoneda;
import wallet.model.entity.Fiat;

/**
 * La clase GestorCompra se encarga de gestionar las transacciones de compra
 * de criptomonedas utilizando moneda fiat. Proporciona métodos para
 * generar y simular compras, así como para verificar la disponibilidad
 * de monedas en la billetera.
 * 
 * @author Grupo13
 * @version 2.0
 * @since 2024
 */
public class GestorCompra {
    private ActivoFiatDAO activoFiatDAO = new ActivoFiatDAO();
    private ActivoCriptoDAO activoCriptoDAO = new ActivoCriptoDAO();
    private TransaccionDAO transaccionDAO = new TransaccionDAO();
    private MonedaDAO monedaDAO = new MonedaDAO();

    /**
     * Genera una compra de criptomonedas, actualizando los activos en la base de
     * datos.
     *
     * @param compra El objeto Compra que contiene la información de la transacción.
     */
    public void generarCompra(Connection c,Compra compra, int idUser, double cantidad) {   
        try { 
            ActivoCripto activoCripto = new ActivoCripto(compra.getCantidad(), compra.getCripto().getNomenclatura());
            ActivoFiat activoFiat = new ActivoFiat(-cantidad, compra.getFiat().getNomenclatura());
            
            int idCripto = monedaDAO.obtenerIdMoneda(compra.getCripto().getNomenclatura());
            int idFiat = monedaDAO.obtenerIdMoneda(compra.getFiat().getNomenclatura());
            if (!activoCriptoDAO.activoExiste(c, idUser,idCripto )) {
                activoCriptoDAO.generarActivoCripto(c,activoCripto, idUser, idCripto);

            } else {
                activoCriptoDAO.actualizarActivo(c,idCripto,idUser,activoCripto);
            }
            
            monedaDAO.actualizarStock(c, -compra.getCantidad(), compra.getCripto().getNomenclatura());
            activoFiatDAO.actualizarActivo(c, idFiat, idUser, activoFiat);      
            transaccionDAO.registrarTransaccion(c, compra,idUser);          
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * Simula una compra de criptomonedas, verificando la existencia de las monedas
     * y
     * la disponibilidad de activos antes de generar el objeto Compra.
     *
     * @param cripto   La criptomoneda que se desea comprar.
     * @param fiat     La moneda fiat utilizada para la compra.
     * @param cantidad La cantidad de moneda fiat que se desea utilizar.
     * @return Un objeto Compra que representa la compra simulada.
     * @throws Exception Si ocurre algún error durante la simulación.
     */
    public int simularCompra(Criptomoneda cripto, Fiat fiat, double cantidad, int idUser) {
        Compra compra = new Compra();
        int error = 0;
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            // verifica si se tiene suficiente activoFiat si no devuelve el error 1
            if (!activoFiatDAO.verificarCantidad(c, idUser, monedaDAO.obtenerIdMoneda(fiat.getNomenclatura()), cantidad))
            {
                error = 1;
            }
            double equivalenteDolarCripto = monedaDAO.equivalenteDolar(cripto.getNomenclatura());
            double equivalenteDolarFiat = monedaDAO.equivalenteDolar(fiat.getNomenclatura());

            // verifica si hay suficiente stock en la billetera si no devuelve el error 2
            double equivalente = (cantidad * equivalenteDolarFiat / equivalenteDolarCripto);
            if (!monedaDAO.VerificarStock(c, cripto.getNomenclatura(), equivalente)) {
                error = 2;
            }
            String resumen = "Compra de "+equivalente+" "+cripto.getNomenclatura()+" con "+cantidad+" "+fiat.getNomenclatura();
            compra = new Compra(LocalDateTime.now(), fiat, cripto, equivalente,cantidad,resumen);
            
            generarCompra(c,compra, idUser,cantidad); 
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return error;
    }

}
