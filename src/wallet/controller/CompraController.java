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

        view.getComprarButton().addActionListener(new comprarAction());
        view.getVolver().addActionListener(new volverAction());
        view.getComboBox().addActionListener(new seleccionAction());
        String nomenclatura = view.monedaAComprar();
        configurarVista(nomenclatura);

    }

    public void configurarVista(String nomenclatura) {
        view.setIcon(model.obtenerRuta(nomenclatura));
        view.setStockLabel(model.obtenerStock(nomenclatura) + nomenclatura);

    }

    class seleccionAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String gastar = view.getGastar().getText();

            double cantidad = Double.parseDouble(gastar);
            String nomenclaturaFidu = view.getComboBox().getSelectedItem().toString();
            view.setRecibir(model.obtenerEquivalente(view.monedaAComprar(), nomenclaturaFidu, cantidad));

        }
    }

    class comprarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Comprar");
        }
    }

    class volverAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.cambiarVista("COTIZACIONES");
        }
    }//

}
