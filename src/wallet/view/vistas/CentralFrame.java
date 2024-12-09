
package wallet.view.vistas;

import net.miginfocom.swing.MigLayout;
import wallet.controller.CompraController;
import wallet.controller.CotizacionesController;
import wallet.controller.MisActivosController;
import wallet.controller.TransaccionesController;
import wallet.dao.interfaces.EventMenuSelected;
import wallet.model.dto.CompraModel;
import wallet.model.dto.CotizacionesModel;
import wallet.model.dto.MisActivosModel;
import wallet.model.dto.TransaccionesModel;
import wallet.view.components.Header;
import wallet.view.components.InicioView;
import wallet.view.components.MainForm;
import wallet.view.components.MenuView;

public class CentralFrame extends javax.swing.JFrame {

    private MigLayout layout;
    private MenuView menu;
    private Header header;
    private MainForm main;

    public CentralFrame(String user) {
        initComponents();
        init(user);
    }

    private void init(String user) {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new MenuView(this);
        header = new Header(user);
        main = new MainForm();

        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex) {
                System.out.println("Menu Index : " + menuIndex);
                if (menuIndex == 1) {
                    main.showForm(new CotizacionesView());
                }
            }

        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2"); // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        // header boton no va
        // empieza con esta vista
        main.showForm(new InicioView());
    }

    public void cambiarVista(String vista) {
        switch (vista) {
            case "COTIZACIONES":
                CotizacionesView cotizacionesView = new CotizacionesView();
                main.showForm(cotizacionesView);
                CotizacionesModel cotizacionesModel = new CotizacionesModel();
                CotizacionesController cotizacionesController = new CotizacionesController(cotizacionesView,
                        cotizacionesModel, this);
                break;
            case "MIS ACTIVOS":
                MisActivosView misActivosView = new MisActivosView();
                main.showForm(misActivosView);
                MisActivosModel misActivosModel = new MisActivosModel();
                MisActivosController misActivosController = new MisActivosController(misActivosView, misActivosModel);
                break;
            case "MIS TRANSACCIONES":
                MisTransaccionesView transaccionesView = new MisTransaccionesView();
                main.showForm(transaccionesView);
                TransaccionesModel transaccionesModel = new TransaccionesModel();
                TransaccionesController transaccionesController = new TransaccionesController(transaccionesView,
                        transaccionesModel, this);
                break;
            case "MIS DATOS":
                main.showForm(new MisDatosView());
                break;
            case "LOGOUT":
                main.showForm(new LogoutView());
                break;
            case "DEPOSITAR":
                main.showForm(new DepositarView());
                break;
            default:
                break;
        }
    }

    public void vistaCompra(String nomenclatura) {
        CompraView compraView = new CompraView(nomenclatura);
        main.showForm(compraView);
        CompraModel compraModel = new CompraModel();
        CompraController compraController = new CompraController(compraView, compraModel, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1200, Short.MAX_VALUE));
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 700, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String user) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentralFrame(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
