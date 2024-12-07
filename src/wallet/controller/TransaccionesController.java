package wallet.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.Main; //?
import wallet.model.dto.TransaccionModel;
import wallet.view.ModelTransaccion;
import wallet.view.TransaccionView;

import wallet.view.MainApp;

public class TransaccionesController {
    private TransaccionView view;
    private ModelTransaccion model;
    private MainApp main; //?

    public TransaccionesController(TransaccionesView view, ModelTransaccion model, MainApp main){
        this.view = view;
        this.model = model;
        this.main = main;

        view.getButton().addActionListener(new BackAction());
    }

    class BackAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            main.setVisible(true);
        }
    } 
}
