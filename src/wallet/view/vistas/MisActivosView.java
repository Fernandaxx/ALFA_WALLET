package wallet.view.vistas;

public class MisActivosView extends javax.swing.JPanel {

        public MisActivosView() {
                initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                tituloLabel = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();

                setBackground(new java.awt.Color(255, 255, 255));

                tituloLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
                tituloLabel.setForeground(new java.awt.Color(182, 183, 192));
                tituloLabel.setText("Mis Activos");

                jTable1.setAutoCreateRowSorter(true);
                jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                jTable1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null }
                                },
                                new String[] {
                                                "", "Moneda", "Monto"
                                }));
                jTable1.setColumnSelectionAllowed(true);
                jScrollPane2.setViewportView(jTable1);
                jTable1.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(103, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(tituloLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                142,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(347, 347,
                                                                                                                                347))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                693,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(97, 97, 97)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(tituloLabel)
                                                                .addGap(72, 72, 72)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                184,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(228, Short.MAX_VALUE)));
        }// </editor-fold>

        // Variables declaration - do not modify
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTable jTable1;
        private javax.swing.JLabel tituloLabel;
        // End of variables declaration
}
