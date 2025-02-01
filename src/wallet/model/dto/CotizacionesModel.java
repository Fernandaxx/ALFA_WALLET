package wallet.model.dto;

import wallet.ConsultarPrecioCripto;

import wallet.dao.impl.MonedaDAO;
import wallet.view.vistas.CotizacionesView;

public class CotizacionesModel {
    MonedaDAO moneda = new MonedaDAO();

    public CotizacionesModel(){
    
    }

    public void actualizarPrecios(double btcPrecio,double ethPrecio,double dogePrecio,double usdcPrecio,double usdtPrecio){
        moneda.actualizarValorDolar(btcPrecio, "BTC");
        moneda.actualizarValorDolar(ethPrecio, "ETH");
        moneda.actualizarValorDolar(dogePrecio, "DOGE");
        moneda.actualizarValorDolar(usdcPrecio, "USDC");
        moneda.actualizarValorDolar(usdtPrecio, "USDT");
    }

    public Double precioCorrecto(double precio, String nomenclatura){
        if (precio == -1){
           precio = moneda.equivalenteDolar(nomenclatura);
        }
        return precio;
    }
    
}
