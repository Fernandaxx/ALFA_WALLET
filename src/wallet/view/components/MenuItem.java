package wallet.view.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import wallet.dao.interfaces.EventMenuSelected;
import wallet.model.entity.Menu;
import wallet.view.vistas.CentralFrame;

public class MenuItem extends javax.swing.JPanel {
    private CentralFrame centralFrame;

    public Menu getMenu() {
        return menu;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public EventMenuSelected getEventSelected() {
        return eventSelected;
    }

    public void setEventSelected(EventMenuSelected eventSelected) {
        this.eventSelected = eventSelected;
    }

    private float alpha;
    private Menu menu;
    private boolean open;
    private EventMenuSelected eventSelected;

    public MenuItem(Menu menu, EventMenuSelected eventSelected, int index, CentralFrame centralFrame) {
        initComponents();
        this.menu = menu;
        this.eventSelected = eventSelected;
        this.centralFrame = centralFrame;
        setOpaque(false);
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 35!]"));
        MenuButton firstItem = new MenuButton(menu.getIcon(), "      " + menu.getMenuName());
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(menu.getMenuName());
                centralFrame.cambiarVista(menu.getMenuName());
            }
        });
        add(firstItem);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));
    }// </editor-fold>

    // Variables declaration - do not modify
    // End of variables declaration
}
