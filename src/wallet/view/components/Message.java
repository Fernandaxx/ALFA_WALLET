package wallet.view.components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Message extends javax.swing.JPanel {
    private javax.swing.JLabel lbMessage;
    private boolean show;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Message() {
        initComponents();
        setOpaque(false);

    }

    public void showMessage(String message) {
        lbMessage.setText(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lbMessage = new javax.swing.JLabel();

        lbMessage.setBackground(new java.awt.Color(215, 220, 225));
        lbMessage.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(248, 248, 248));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));
    }// </editor-fold>

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(new Color(108, 108, 108));

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        // g2.setColor(new Color(245, 245, 245));
        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(grphcs);
    }

}
