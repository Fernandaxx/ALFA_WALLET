package wallet.model.dto;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import wallet.dao.impl.ActivoCriptoDAO;
import wallet.dao.impl.ActivoFiatDAO;
import wallet.dao.impl.MonedaDAO;
import wallet.model.entity.Activo;
import wallet.model.entity.ActivoCripto;
import wallet.model.entity.ActivoFiat;
import wallet.model.entity.Criptomoneda;
import wallet.model.entity.Fiat;
import wallet.view.components.ModeloTabla;

public class MisActivosModel {
    private ActivoCriptoDAO activoCriptoDAO = new ActivoCriptoDAO();
    private ActivoFiatDAO activoFiatDAO = new ActivoFiatDAO();
    private MonedaDAO monedaDAO = new MonedaDAO();
    private final String[] columnas = { "", "Moneda", "Monto" };

    public MisActivosModel() {
    }

    public Double getBalance(int idUsuario) {
        double balance = 0;
        double eq;
        List<ActivoCripto> activosCripto = activoCriptoDAO.listarActivosCripto(idUsuario);
        List<ActivoFiat> activosFiat = activoFiatDAO.listarActivosFiat(idUsuario);

        for (ActivoFiat activoFiat : activosFiat) {
            eq = monedaDAO.equivalenteDolar(activoFiat.getFiat().getNomenclatura());
            balance += eq * activoFiat.getCantidad();
        }
        for (ActivoCripto activoCripto : activosCripto) {
            eq = monedaDAO.equivalenteDolar(activoCripto.getCripto().getNomenclatura());
            balance += eq * activoCripto.getCantidad();

        }
        return balance;
    }

    public ModeloTabla obtenerDatos(int idUsuario) {
        List<ActivoCripto> activosCripto = activoCriptoDAO.listarActivosCripto(idUsuario);
        List<ActivoFiat> activosFiat = activoFiatDAO.listarActivosFiat(idUsuario);

        int totalSize = activosCripto.size() + activosFiat.size();
        Object[][] datos = new Object[totalSize][3];

        int index = 0;
        for (ActivoCripto actC : activosCripto) {
            datos[index][0] = new ImageIcon(getClass().getResource(actC.getCripto().getIconRuta()));
            datos[index][1] = actC.getCripto().getNombre();
            datos[index][2] = actC.getCantidad();
            index++;
        }

        for (ActivoFiat actF : activosFiat) {
            datos[index][0] = new ImageIcon(getClass().getResource(actF.getFiat().getIconRuta()));
            datos[index][1] = actF.getFiat().getNombre();
            datos[index][2] = actF.getCantidad();
            index++;
        }

        ModeloTabla modelo = new ModeloTabla(datos, columnas);

        return modelo;
    }

    public void generarDatos(int idUsuario) {
        int[] idMonedas = { monedaDAO.obtenerIdMoneda("BTC"), monedaDAO.obtenerIdMoneda("ETH"),
                monedaDAO.obtenerIdMoneda("ARS"), monedaDAO.obtenerIdMoneda("USD") };
        activoCriptoDAO.generarActivoCripto(new ActivoCripto(1, new Criptomoneda("BTC")), idUsuario, idMonedas[0]);
        activoCriptoDAO.generarActivoCripto(new ActivoCripto(5, new Criptomoneda("ETH")), idUsuario, idMonedas[1]);
        activoFiatDAO.generarActivoFiat(new ActivoFiat(10000, new Fiat("ARS")), idUsuario, idMonedas[2]);
    }
}
