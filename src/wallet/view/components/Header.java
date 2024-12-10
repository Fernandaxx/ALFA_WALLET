
package wallet.view.components;

import wallet.dao.impl.UsuarioDAO;

public class Header extends javax.swing.JPanel {
        private String nombre;

        public Header(int idUser) {
                this.nombre = new UsuarioDAO().buscarUsuarioPorId(idUser).getPersona().getNombre();
                initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                icon = new wallet.view.components.ImageAvatar();
                jLabel1 = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();
                nombreUsuario = new javax.swing.JLabel();

                setBackground(new java.awt.Color(255, 255, 255));

                icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user.png"))); // NOI18N

                jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(153, 153, 153));
                jLabel1.setText("User");
                jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

                nombreUsuario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
                nombreUsuario.setForeground(new java.awt.Color(153, 153, 153));
                nombreUsuario.setText(nombre);
                nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(442, Short.MAX_VALUE)
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                15,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                37,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(nombreUsuario,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(icon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator1)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(nombreUsuario)
                                                                                                                .addComponent(icon,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                31,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(8, 8, 8)))
                                                                .addGap(6, 6, 6)));
        }// </editor-fold>

        // Variables declaration - do not modify
        private wallet.view.components.ImageAvatar icon;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JLabel nombreUsuario;
        // End of variables declaration
}
