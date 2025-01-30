package wallet.model.dto;

import java.util.List;
import wallet.exception.FiatInsuficienteException;
import wallet.exception.StockInsuficienteException;
import wallet.dao.impl.GestorCompra;
import wallet.dao.impl.MonedaDAO;
import wallet.model.entity.Compra;
import wallet.model.entity.Stock;
import wallet.view.vistas.CompraView;
import wallet.model.entity.Criptomoneda;
import wallet.model.entity.Fiat;

public class CompraModel {
    private Compra compra;
    private MonedaDAO monedaDAO = new MonedaDAO();
    private GestorCompra gestorCompra = new GestorCompra();

    public CompraModel() {
    }

    public void generarCompra(String nomenclaturaCripto,String nomenclaturaFiat,double cantidad,int idUser ) throws StockInsuficienteException,FiatInsuficienteException{
        Criptomoneda cripto = new Criptomoneda(nomenclaturaCripto);
        Fiat fiat = new Fiat(nomenclaturaFiat);
        int error = gestorCompra.simularCompra(cripto, fiat, cantidad, idUser);
        if (error == 1) {
            throw new FiatInsuficienteException();
        }
        if (error == 2){
            throw new StockInsuficienteException();
        }
        
    }

    public String obtenerRuta(String nomenclatura) {
        return monedaDAO.obtenerNombre(nomenclatura);
    }

    public String obtenerStock(String nomenclatura) {
        String nomenclaturaStock = "";
        List<Stock> stocks = monedaDAO.listarStock();
        for (Stock stock : stocks) {
            if (stock.getNomenclatura().equals(nomenclatura)) {
                nomenclaturaStock = String.valueOf(stock.getCantidad());
            }
        }
        return nomenclaturaStock;
    }

    public String obtenerEquivalente(String nomenclaturaCrip, String nomenclaturaFiat, double cantidad) {
        double e = monedaDAO.equivalente(nomenclaturaCrip, nomenclaturaFiat, cantidad);
        return String.valueOf(e);

    }

}
