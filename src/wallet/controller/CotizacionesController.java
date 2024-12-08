package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        view.getPepeButton().addActionListener(new comprarAction("PEPE"));
        view.getSolButton().addActionListener(new comprarAction("SOL"));
        view.getUsdcButton().addActionListener(new comprarAction("USDC"));
        view.getUsdtButton().addActionListener(new comprarAction("USDT"));

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
}
