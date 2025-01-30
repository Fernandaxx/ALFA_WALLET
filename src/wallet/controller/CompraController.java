package wallet.controller;

import wallet.exception.FiatInsuficienteException;
import wallet.exception.StockInsuficienteException;
import wallet.model.dto.CompraModel;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.CompraView;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class CompraController {
    private CompraView view;
    private CentralFrame frame;
    private CompraModel model;
    private int idUser;

    public CompraController(CompraView view, CompraModel model, CentralFrame frame, int idUser) {
        this.view = view;
        this.frame = frame;
        this.model = model;
        this.idUser = idUser;

        view.getVolver().addActionListener(new volverAction());
        view.getComboBox().addActionListener(new seleccionAction());
        String nomCripto = view.monedaAComprar();
        configurarVista(nomCripto);
        view.getComprarButton().addActionListener(new comprarAction());
        /*
         * String gastar = view.getGastar().getText();
         * double cantidad = Double.parseDouble(gastar);
         * view.getComprarButton().addActionListener(new comprarAction(nomCripto,
         * view.getComboBox().getSelectedItem().toString(), cantidad));
         */

    }

    public void configurarVista(String nomenclatura) {
        view.setIcon(model.obtenerRuta(nomenclatura));
        view.setIcon(model.obtenerRuta(nomenclatura));
        
        view.setStockLabel(model.obtenerStock(nomenclatura) + nomenclatura);

    }

    class seleccionAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String gastar = view.getGastar().getText();
            if (gastar.isEmpty()) {
                //view.showMessage("Funciono?");
               // JOptionPane.showMessageDialog(view, "Por favor, ingrese un valor para gastar", "Advertencia", JOptionPane.WARNING_MESSAGE);
               // System.out.println("Por favor, ingresa un valor para gastar.");
                return;
            }
            double cantidad = Double.parseDouble(gastar);
            String nomenclaturaFidu = view.getComboBox().getSelectedItem().toString();
            view.setRecibir(model.obtenerEquivalente(view.monedaAComprar(), nomenclaturaFidu, cantidad));

        }
    }

    class comprarAction implements ActionListener {
        String nomenclaturaFiat;
        String nomenclaturaCripto;
        double cantidad;

        public comprarAction() {

        }

        public comprarAction(String nomenclaturaCripto, String nomenclaturaFiat, double cantidad) {
            this.nomenclaturaFiat = nomenclaturaFiat;
            this.nomenclaturaCripto = nomenclaturaCripto;
            this.cantidad = cantidad;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String gastar = view.getGastar().getText();
            if (gastar.isEmpty()) {
                view.mostrarMensajeAdv("Por favor, ingrese un valor para gastar");
                return;
            }
            double cantidad = Double.parseDouble(gastar);
            String nomenclaturaFiat = view.getComboBox().getSelectedItem().toString();
            String nomenclaturaCripto = view.monedaAComprar();
            try{
                model.generarCompra(nomenclaturaCripto, nomenclaturaFiat, cantidad, idUser);
                view.mostrarMensajeInfo("Realizo una compra de "+nomenclaturaCripto);
            }catch (FiatInsuficienteException ex){
                view.mostrarMensajeError(ex.getMessage());
            }catch (StockInsuficienteException ex){
                view.mostrarMensajeError(ex.getMessage());
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
