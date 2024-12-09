package wallet.model.dto;
import java.util.TimerTask;

import wallet.ConsultarPrecioCripto;
import wallet.MyTimerTask;
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
}
