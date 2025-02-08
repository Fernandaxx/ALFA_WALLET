package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.dto.TransaccionesModel;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.MisTransaccionesView;

public class TransaccionesController {
    private MisTransaccionesView view;
    private TransaccionesModel model;
    private CentralFrame centralFrame;

    public TransaccionesController(MisTransaccionesView view, TransaccionesModel model, CentralFrame centralFrame) {
        this.view = view;
        this.model = model;
        this.centralFrame = centralFrame;

    }

    class BackAction implements ActionListener {
        public BackAction() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            centralFrame.cambiarVista("MIS ACTIVOS");
        }
    }
}
