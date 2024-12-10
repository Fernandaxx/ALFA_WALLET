
package wallet.view.vistas;

import wallet.view.components.Button;

import wallet.view.components.MyTextField;
import javax.swing.JComboBox;

import net.miginfocom.swing.MigLayout;

public class CompraView extends javax.swing.JPanel {
        private String nomenclatura;
        private javax.swing.JLabel Icon;
        private wallet.view.components.Button comprar;
        private MyTextField gastar;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private wallet.view.components.MyTextField recibir;
        private javax.swing.JLabel stockLabel;
        private wallet.view.components.Button volver;

        public CompraView(String nomenclatura) {

                this.nomenclatura = nomenclatura;
                initComponents();
                setOpaque(false);
        }

        public String monedaAComprar() {
                return this.nomenclatura;
        }

        public JComboBox<String> getComboBox() {
                return jComboBox1;
        }

        public void setRecibir(String monto) {
                recibir.setText(monto);
        }

        public Button getVolver() {
                return volver;
        }

        public MyTextField getGastar() {
                return gastar;
        }

        public Button getComprarButton() {
                return comprar;
        }

        public void setIcon(String ruta) {
                this.Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
        }

        public void setStockLabel(String stock) {
                this.stockLabel.setText(stock);
        }

        /*
         * public void showMessage(String message) {
         * Message msg = new Message();
         * msg.showMessage(message);
         * TimingTarget target = new TimingTargetAdapter() {
         * 
         * @Override
         * public void begin() {
         * if (!msg.isShow()) {
         * add(msg, "pos 0.5al -30", 0); // Insert to bg fist index 0
         * setVisible(true);
         * repaint();
         * }
         * }
         * 
         * @Override
         * public void timingEvent(float fraction) {
         * float f;
         * if (msg.isShow()) {
         * f = 40 * (1f - fraction);
         * } else {
         * f = 40 * fraction;
         * }
         * layout.setComponentConstraints(msg, "pos 0.5al " + (int) (f - 30));
         * repaint();
         * revalidate();
         * }
         * 
         * @Override
         * public void end() {
         * if (msg.isShow()) {
         * remove(msg);
         * repaint();
         * revalidate();
         * } else {
         * msg.setShow(true);
         * }
         * }
         * };
         * Animator animator = new Animator(300, target);
         * animator.setResolution(0);
         * animator.setAcceleration(0.5f);
         * animator.setDeceleration(0.5f);
         * animator.start();
         * new Thread(new Runnable() {
         * 
         * @Override
         * public void run() {
         * try {
         * Thread.sleep(2000000000);
         * animator.start();
         * } catch (InterruptedException e) {
         * System.err.println(e);
         * }
         * }
         * }).start();
         * }
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                gastar = new wallet.view.components.MyTextField();
                recibir = new wallet.view.components.MyTextField();
                jComboBox1 = new javax.swing.JComboBox<>();
                jLabel1 = new javax.swing.JLabel();
                stockLabel = new javax.swing.JLabel();
                volver = new wallet.view.components.Button();
                comprar = new wallet.view.components.Button();
                Icon = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();

                setBackground(new java.awt.Color(255, 255, 255));

                jPanel1.setBackground(new java.awt.Color(195, 195, 195));
                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
                                new java.awt.Color(51, 51, 51), null, null));

                gastar.setHint("GASTAR");
                gastar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                gastarActionPerformed(evt);
                        }
                });

                recibir.setHint("RECIBIR");
                recibir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                recibirActionPerformed(evt);
                        }
                });

                jComboBox1.setEditable(true);
                jComboBox1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
                jComboBox1.setForeground(new java.awt.Color(130, 130, 130));
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "---", "ARS", "USD" }));
                jComboBox1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                jComboBox1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox1ActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                jLabel1.setText("Stock disponible:");

                stockLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                stockLabel.setText(nomenclatura);

                volver.setBackground(new java.awt.Color(150, 150, 150));
                volver.setText("Cancelar");
                volver.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                volverActionPerformed(evt);
                        }
                });

                comprar.setBackground(new java.awt.Color(156, 156, 156));
                comprar.setText("Comprar");
                comprar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                comprarActionPerformed(evt);
                        }
                });

                Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/BTC.png"))); // NOI18N

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                132,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(stockLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 6, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                                                .addComponent(comprar,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                91,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(36, 36, 36)
                                                                                                                                                                .addComponent(volver,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                91,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                                .addComponent(gastar,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                143,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(recibir,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                143,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addComponent(jComboBox1,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                80,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                                                                                .addComponent(Icon,
                                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                                47,
                                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                                                .addContainerGap(56, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(76, 76, 76)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(stockLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(gastar,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(recibir,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(Icon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(comprar,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(volver,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(54, Short.MAX_VALUE)));

                jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(157, 157, 157));
                jLabel2.setText("COMPRAR");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(358, 358, 358)
                                                                                                .addComponent(jLabel2))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(268, 268, 268)
                                                                                                .addComponent(jPanel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(290, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(77, Short.MAX_VALUE)));
        }// </editor-fold>

        private void gastarActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void recibirActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void volverActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void comprarActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

}
