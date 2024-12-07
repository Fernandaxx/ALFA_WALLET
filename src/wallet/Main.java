package wallet;

import wallet.config.DataBaseConfig;
import wallet.view.vistas.InicialFrame;

public class Main {
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        DataBaseConfig dataBase = new DataBaseConfig();
        dataBase.CreateDatabase();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicialFrame().setVisible(true);
            }
        });

    }
}
