
package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.dto.MisActivosModel;
import wallet.view.vistas.MisActivosView;

public class MisActivosController {
    private MisActivosView view;
    private MisActivosModel model;
    private int idUsuario;

    public MisActivosController(MisActivosView view, MisActivosModel model, int idUsuario) {
        this.view = view;
        this.model = model;
        this.idUsuario = idUsuario;

        view.getGenerarButton().addActionListener(new generarAction(idUsuario));
        view.getExportarButton().addActionListener(new exportarCSVAction());

        view.setBalanceLabel(String.valueOf(model.getBalance(idUsuario)));
        setTabla();

    }

    private void setTabla() {
        view.cargarActivos(model.obtenerDatos(this.idUsuario));
    }

    class generarAction implements ActionListener {
        private int idUsuario;

        generarAction(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.generarDatos(this.idUsuario);
            setTabla();
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
