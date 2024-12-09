package wallet.model.dto;

import java.util.List;

import wallet.dao.impl.GestorCompra;
import wallet.dao.impl.MonedaDAO;
import wallet.model.entity.Compra;
import wallet.model.entity.Stock;

public class CompraModel {
    private Compra compra;
    private MonedaDAO monedaDAO = new MonedaDAO();
    private GestorCompra gestorCompra = new GestorCompra();

    public CompraModel() {
    }

    public String obtenerRuta(String nomenclatura) {
        System.out.println("Aqui3");
        return monedaDAO.obtenerNombre(nomenclatura);
    }

    public String obtenerStock(String nomenclatura) {
        String nomenclaturaStock = "";
        System.out.println("Aqui2");
        List<Stock> stocks = monedaDAO.listarStock();
        for (Stock stock : stocks) {
            if (stock.getNomenclatura().equals(nomenclatura)) {
                nomenclaturaStock = stock.getNomenclatura();
            }
        }
        return nomenclaturaStock;
    }

    public String obtenerEquivalente(String nomenclaturaCrip, String nomenclaturaFiat, double cantidad) {
        System.out.println("Aqui1");
        double e = monedaDAO.equivalente(nomenclaturaCrip, nomenclaturaFiat, cantidad);
        return String.valueOf(e);

    }

}
