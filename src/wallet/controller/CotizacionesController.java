package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import wallet.ConsultarPrecioCripto;
import wallet.model.dto.CotizacionesModel;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.CotizacionesView;

public class CotizacionesController {
    private CotizacionesView view;
    private CotizacionesModel model;
    private CentralFrame centralFrame;

    public CotizacionesController(CotizacionesView view, CotizacionesModel model, CentralFrame centralFrame) {
        this.view = view;
        this.model = model;
        this.centralFrame = centralFrame;

        view.getBtcButton().addActionListener(new comprarAction("BTC"));
        view.getEthButton().addActionListener(new comprarAction("ETH"));
        view.getDogeButton().addActionListener(new comprarAction("DOGE"));
        view.getUsdcButton().addActionListener(new comprarAction("USDC"));
        view.getUsdtButton().addActionListener(new comprarAction("USDT"));

        precio(view, model);
    }

    class comprarAction implements ActionListener {
        private String nomenclatura;

        public comprarAction(String nomenclatura) {
            this.nomenclatura = nomenclatura;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Comprar " + nomenclatura);
            // agregar que el modelo verifique si la nomenclatura ya esta en la BD
            centralFrame.vistaCompra(nomenclatura);

        }
    }

    private void precio(CotizacionesView view, CotizacionesModel model) {
        Timer timer = new Timer();
        TimerTask task = new MyTimerTask(view, model);
        timer.schedule(task, 10, 60000);
    }

    class MyTimerTask extends TimerTask {
        private CotizacionesView view;
        private ConsultarPrecioCripto consultar;

        public MyTimerTask(CotizacionesView view, CotizacionesModel model) {
            this.view = view;
            this.consultar = new ConsultarPrecioCripto();
        }

        @Override
        public void run() {
            // Obtener precios de criptomonedas
            double btcPrecio = consultar.getPrecioCripto("BTC");
            double ethPrecio = consultar.getPrecioCripto("ETH");
            double dogePrecio = consultar.getPrecioCripto("DOGE");
            double usdcPrecio = consultar.getPrecioCripto("USDC");
            double usdtPrecio = consultar.getPrecioCripto("USDT");
  
            if (btcPrecio == -1){
                btcPrecio = model.precioCorrecto(btcPrecio, "BTC");
            }
            if (ethPrecio == -1){
                ethPrecio = model.precioCorrecto(ethPrecio, "ETH");
            }
            if (dogePrecio == -1){
                dogePrecio = model.precioCorrecto(dogePrecio, "DOGE");
            }
            if (usdcPrecio == -1){
                usdcPrecio = model.precioCorrecto(usdcPrecio, "USDC");
            }
            if (usdtPrecio == -1){
                usdtPrecio = model.precioCorrecto(usdtPrecio, "USDT");
            }
            actualizarPreciosVista(btcPrecio, ethPrecio, dogePrecio, usdcPrecio, usdtPrecio);
            model.actualizarPrecios(btcPrecio, ethPrecio, dogePrecio, usdcPrecio, usdtPrecio);
        }

        private void actualizarPreciosVista(double btcPrecio,double ethPrecio,double dogePrecio,double usdcPrecio,double usdtPrecio){
            view.setBtcLabel(String.valueOf(btcPrecio));
            view.setEthLabel(String.valueOf(ethPrecio));
            view.setDogeLabel(String.valueOf(dogePrecio));
            view.setUsdcLabel(String.valueOf(usdcPrecio));
            view.setUsdtLabel(String.valueOf(usdtPrecio));
        }
    }

}
