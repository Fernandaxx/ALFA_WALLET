package wallet.view.vistas;

import wallet.view.components.Button;
import wallet.ConsultarPrecioCripto;

public class CotizacionesView extends javax.swing.JPanel {

        public CotizacionesView() {
                initComponents();
                setOpaque(false);
        }

        public Button getBtcButton() {
                return btcButton;
        }

        public Button getEthButton() {
                return ethButton;
        }

        public Button getUsdcButton() {
                return usdcButton;
        }

        public Button getUsdtButton() {
                return usdtButton;
        }

        public Button getDogeButton() {
                return dogeButton;
        }

        public void setBtcLabel(String btcLabel) {
                BtcLabel.setText(btcLabel);
        }

        public void setEthLabel(String ethLabel) {
                EthLabel.setText(ethLabel);
        }

        public void setUsdcLabel(String usdcLabel) {
                this.usdcLabel.setText(usdcLabel);
        }

        public void setUsdtLabel(String usdtLabel) {
                this.usdtLabel.setText(usdtLabel);
        }

        public void setDogeLabel(String dogeLabel) {
                this.dogeLabel.setText(dogeLabel);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
                jSeparator1 = new javax.swing.JSeparator();

                tituloLabel = new javax.swing.JLabel();
                tituloLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
                tituloLabel.setForeground(new java.awt.Color(182, 183, 192));
                tituloLabel.setText("COTIZACIONES");

                btcButton = new wallet.view.components.Button();
                btcButton.setText("COMPRAR");

                ethButton = new wallet.view.components.Button();
                ethButton.setText("COMPRAR");

                usdcButton = new wallet.view.components.Button();
                usdcButton.setText("COMPRAR");

                usdtButton = new wallet.view.components.Button();
                usdtButton.setText("COMPRAR");

                dogeButton = new wallet.view.components.Button();
                dogeButton.setText("COMPRAR");

                precioLabel = new javax.swing.JLabel();
                precioLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                precioLabel.setText("Precio (Usd) ");

                criptoLabel = new javax.swing.JLabel();
                criptoLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                criptoLabel.setText("Criptomoneda");

                accionLabel = new javax.swing.JLabel();
                accionLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                accionLabel.setText("Accion");

                ethIcon = new javax.swing.JLabel();
                ethIcon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                ethIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ETH.png"))); // NOI18N
                ethIcon.setText("Ethereum(ETH)");

                btcIcon = new javax.swing.JLabel();
                btcIcon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                btcIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/BTC.png"))); // NOI18N
                btcIcon.setText("Bitcoin(BTC)");

                usdtIcon = new javax.swing.JLabel();
                usdtIcon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                usdtIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/USDT.png"))); // NOI18N
                usdtIcon.setText("Tether(USDT)");

                usdcIcon = new javax.swing.JLabel();
                usdcIcon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                usdcIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/USDC.png"))); // NOI18N
                usdcIcon.setText("Usdc(USDC)");

                dogeIcon = new javax.swing.JLabel();
                dogeIcon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
                dogeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DOGE.png"))); // NOI18N
                dogeIcon.setText("Dogecoin(DOGE)");

                usdtLabel = new javax.swing.JLabel();
                usdtLabel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
                usdtLabel.setText("");

                EthLabel = new javax.swing.JLabel();
                EthLabel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
                EthLabel.setText("100.000");

                usdcLabel = new javax.swing.JLabel();
                usdcLabel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
                usdcLabel.setText("100.000");

                BtcLabel = new javax.swing.JLabel();
                BtcLabel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
                BtcLabel.setText("100.000");

                dogeLabel = new javax.swing.JLabel();
                dogeLabel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
                dogeLabel.setText("100.000");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                651,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(196, 196, 196)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(criptoLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                114,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(btcIcon,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                161,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(ethIcon,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(118, 118, 118)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                                                .addComponent(BtcLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                94,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(EthLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                94,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(usdcLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                94,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(usdtLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                94,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(dogeLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                94,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(precioLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                99,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(91, 91, 91)
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                                                .addComponent(accionLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                76,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(btcButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                70,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(ethButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                70,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(usdcButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                70,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(usdtButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                70,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                                                                .addComponent(dogeButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                70,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addComponent(dogeIcon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                177,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(usdtIcon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                149,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(usdcIcon,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                149,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(279, 279, 279)
                                                                .addComponent(tituloLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                190, Short.MAX_VALUE)
                                                                .addGap(313, 313, 313)));

                layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btcIcon, dogeIcon,
                                ethIcon, usdcIcon, usdtIcon });

                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(tituloLabel)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(criptoLabel)
                                                                                .addComponent(precioLabel)
                                                                                .addComponent(accionLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(btcIcon)
                                                                                .addComponent(BtcLabel)
                                                                                .addComponent(btcButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(ethIcon)
                                                                                .addComponent(EthLabel)
                                                                                .addComponent(ethButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(usdcIcon)
                                                                                .addComponent(usdcLabel)
                                                                                .addComponent(usdcButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(usdtIcon)
                                                                                .addComponent(usdtLabel)
                                                                                .addComponent(usdtButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.CENTER)
                                                                                .addComponent(dogeIcon)
                                                                                .addComponent(dogeLabel)
                                                                                .addComponent(dogeButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

                layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btcButton, ethButton,
                                usdcButton, usdtButton });

                layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btcIcon, dogeIcon,
                                ethIcon, usdcIcon, usdtIcon });

        }// </editor-fold>

        // Variables declaration - do not modify
        // precios que se actualizan en tiempo real
        private javax.swing.JLabel BtcLabel;
        private javax.swing.JLabel EthLabel;
        private javax.swing.JLabel dogeLabel;

        private javax.swing.JLabel usdcLabel;
        private javax.swing.JLabel usdtLabel;

        // botones de compra
        private wallet.view.components.Button btcButton;
        private wallet.view.components.Button dogeButton;
        private wallet.view.components.Button ethButton;

        private wallet.view.components.Button usdcButton;
        private wallet.view.components.Button usdtButton;

        // iconos de criptomonedas y nombres
        private javax.swing.JLabel btcIcon;
        private javax.swing.JLabel dogeIcon;
        private javax.swing.JLabel ethIcon;

        private javax.swing.JLabel usdtIcon;
        private javax.swing.JLabel usdcIcon;

        private javax.swing.JLabel accionLabel;
        private javax.swing.JLabel tituloLabel;
        private javax.swing.JLabel criptoLabel;
        private javax.swing.JLabel precioLabel;
        private javax.swing.JSeparator jSeparator1;
        // End of variables declaration
}
