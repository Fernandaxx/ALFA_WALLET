package wallet.view.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import wallet.dao.interfaces.EventMenu;
import wallet.dao.interfaces.EventMenuSelected;
import wallet.model.entity.Menu;

public class MenuView extends javax.swing.JPanel {

    private final MigLayout layout;
    private EventMenuSelected event;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public MenuView() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public void initMenuItem() {
        addMenu(new Menu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "DEPOSITAR"));
        addMenu(new Menu(new ImageIcon(getClass().getResource("/com/raven/icon/2.png")), "MIS ACTIVOS"));
        addMenu(new Menu(new ImageIcon(getClass().getResource("/com/raven/icon/3.png")), "COTIZACIONES"));
        addMenu(new Menu(new ImageIcon(getClass().getResource("/com/raven/icon/4.png")), "MIS TRANSACCIONES"));
        addMenu(new Menu(new ImageIcon(getClass().getResource("/com/raven/icon/5.png")), "MIS DATOS"));
        addMenu(new Menu(new ImageIcon(getClass().getResource("/com/raven/icon/6.png")), " "));
    }

    private void addMenu(Menu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        System.out.print("show menu pop out");
                    }
                }
                return false;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alfaWallet1 = new wallet.view.components.AlfaWallet();
        panel = new javax.swing.JPanel();
        alfaWallet2 = new wallet.view.components.AlfaWallet();

        alfaWallet1.setOpaque(false);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 135, Short.MAX_VALUE));

        alfaWallet2.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(alfaWallet2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(alfaWallet2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(388, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(151, 10, 151), getWidth(), 0, new Color(94, 0, 94));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private wallet.view.components.AlfaWallet alfaWallet1;
    private wallet.view.components.AlfaWallet alfaWallet2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
