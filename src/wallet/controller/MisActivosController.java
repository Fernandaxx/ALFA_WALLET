
package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.dto.MisActivosModel;
import wallet.view.vistas.MisActivosView;

public class MisActivosController {
    private MisActivosView view;
    private MisActivosModel model;

    public MisActivosController(MisActivosView view, MisActivosModel model) {
        this.view = view;
        this.model = model;

        view.getGenerarButton().addActionListener(new generarAction());
        view.getExportarButton().addActionListener(new exportarCSVAction());

    }

    class generarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Generar");
        }
    }

    class exportarCSVAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Exportar");
        }
    }
}
