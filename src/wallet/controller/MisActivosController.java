
package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import wallet.model.dto.MisActivosModel;
import wallet.view.components.ModeloTabla;
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
        ModeloTabla tabla = model.obtenerDatos(this.idUsuario);
        if (tabla != null) {

            view.cargarActivos(tabla);
        }
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
            view.setBalanceLabel(String.valueOf(model.getBalance(idUsuario)));
        }
    }

    class exportarCSVAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            int resExp = model.exportar(idUsuario);
            if (resExp == 0){
                view.mostrarMensajeInfo("Archivo CSV exportado correctamente ") ;
            }
            else if ( resExp == 1){
                view.mostrarMensajeAdv("No hay activos para exportar");
            }

        }
    }
}
