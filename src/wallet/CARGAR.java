package wallet;

import java.nio.channels.ByteChannel;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.LinkedList;

import wallet.dao.impl.*;
import wallet.model.entity.Moneda;
import wallet.model.entity.*;

public class CARGAR {
    public static void main(String[] args) {
        // Crear instancia del DAO
        //TransaccionDAO dao = new TransaccionDAO();
        //ActivoCriptoDAO daoCripto = new ActivoCriptoDAO();
        ActivoFiatDAO daoFiat = new ActivoFiatDAO();
        //ActivoCripto cripto = new ActivoCripto(1000, "BTC");
        //daoCripto.generarActivoCripto( cripto,1, 8);
        ActivoFiat fiat = new ActivoFiat(50000, "ARS");
        daoFiat.generarActivoFiat(fiat, 1, 13);

       /* MonedaDAO dao = new MonedaDAO();
        dao.borrarMoneda("ETH");
        dao.borrarMoneda("DOGE");
        dao.borrarMoneda("USDT");
        dao.borrarMoneda("USDC");
        dao.borrarMoneda("ARS");
        dao.borrarMoneda("USD");

       Compra compra = new Compra(LocalDateTime.now(),"Compra de ETH");
        int idUsuario = 1;
        // Establecer la conexión con la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db")) {
            // Registrar la transacción
            dao.registrarTransaccion(connection, compra, idUsuario);
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
