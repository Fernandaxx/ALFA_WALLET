package wallet.controller;

import wallet.model.dto.CompraModel;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.CompraView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraController {
    private CompraView view;
    private CentralFrame frame;
    private CompraModel model;

    public CompraController(CompraView view, CompraModel model, CentralFrame frame) {
        this.view = view;
        this.frame = frame;
        this.model = model;

        view.getVolver().addActionListener(new volverAction());
        view.getComboBox().addActionListener(new seleccionAction());
        String nomCripto = view.monedaAComprar();
        view.getComprarButton().addActionListener(new comprarAction(nomCripto,view.getComboBox().getSelectedItem().toString(),Double.parseDouble(view.getGastar().getText())));
        configurarVista(nomCripto);

    }

    public void configurarVista(String nomenclatura) {
        view.setIcon(model.obtenerRuta(nomenclatura));
        view.setStockLabel(model.obtenerStock(nomenclatura) + nomenclatura);

    }

    class seleccionAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String gastar = view.getGastar().getText();
<<<<<<< HEAD

            double cantidad = Double.parseDouble(gastar);
            String nomenclaturaFidu = view.getComboBox().getSelectedItem().toString();
            view.setRecibir(model.obtenerEquivalente(view.monedaAComprar(), nomenclaturaFidu, cantidad));
=======
            if (gastar != "Gastar") {
                double cantidad = Double.parseDouble(gastar);
                String nomenclaturaFidu = view.getComboBox().getSelectedItem().toString();
                view.setRecibir(model.obtenerEquivalente(view.monedaAComprar(), nomenclaturaFidu, cantidad));
            }
>>>>>>> 8dd462f0694abbc16e3e239513617ce6bb307607

        }
    }

    class comprarAction implements ActionListener {
        String nomenclaturaFiat;
        String nomenclaturaCripto;
        double cantidad;
        
        public comprarAction(String nomenclaturaCripto,String nomenclaturaFiat,double cantidad){
            this.nomenclaturaFiat= nomenclaturaFiat;
            this.nomenclaturaCripto = nomenclaturaCripto;
            this.cantidad = cantidad;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int error = model.generarCompra(nomenclaturaFiat,nomenclaturaCripto,cantidad);
            if (error == 1) {
                view.showMessage("error no hay suficiente Activo fiat");
            }else if (error==2){
                view.showMessage("error no hay suficiente Stock ");
                }
            }
        }
    

    class volverAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.cambiarVista("COTIZACIONES");
        }
    }//

}
