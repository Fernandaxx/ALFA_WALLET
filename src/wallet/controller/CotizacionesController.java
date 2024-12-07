package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.Main; //??
import wallet.model.dto.CotizacionesModel;
import wallet.view.ModelCotizacion;
import wallet.view.CotizacionView;

import wallet.view.MainApp; 

public class CotizacionesController {
    private CotizacionesView view;
    private ModelCotizaciones model;
    private MainApp main;


    public CotizacionesController(CotizacionesView view, ModelCotizaciones model, Main main){
        this.view = view;
        this.model = model;
        this.main = main;  
       
        view.getButton().addActionListener(new BackAction());

        view.getButtonBitcoin().addActionListener(new ComprarAction(BTC));
        view.getButtonEthereum().addActionListener(new ComprarAction(ETH));
        view.getButtonUsdc().addActionListener(new ComprarAction(USDC)); 
        view.getButtonUsdt().addActionListener(new ComprarAction(USDT));
        view.getButtonDogecoin().addActionListener(new ComprarAction(DOGE));
    }

    class ComprarAction implements ActionListener {
        private String nomenclatura;

        public ComprarAction(String nomenclatura){
            this.nomenclatura = nomenclatura;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar la vista de compra con los datos de la criptomoneda seleccionada
            CompraView compraView = new CompraView(nomenclatura);
            view.setVisible(false);
            CompraView.setVisible(true);
        }
    }

    class BackAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            main.setVisible(true);
        }
    } 
}
