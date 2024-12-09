package wallet;

import wallet.config.DataBaseConfig;
import wallet.dao.impl.MonedaDAO;
import wallet.model.entity.Criptomoneda;
import wallet.model.entity.Fiat;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.InicialFrame;

public class Main {
        public static void main(String args[]) {

                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(InicialFrame.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }

                DataBaseConfig dataBase = new DataBaseConfig();
                dataBase.CreateDatabase();

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new InicialFrame().setVisible(true);
                                // new CentralFrame(1).setVisible(true);
                        }
                });

                // cargarMonedas();

        }

        private static void cargarMonedas() {
                MonedaDAO dao = new MonedaDAO();
                Criptomoneda cripto1 = new Criptomoneda('C', "Bitcoin", "BTC", 8888, 0.5, 10000, "/resources/BTC.png");
                Criptomoneda cripto2 = new Criptomoneda('C', "Ethereum", "ETH", 8888, 0.6, 10000, "/resources/ETH.png");
                Criptomoneda cripto3 = new Criptomoneda('C', "Usdc", "USDC", 8888, 0.1, 10000, "/resources/USDC.png");
                Criptomoneda cripto4 = new Criptomoneda('C', "Tether", "USDT", 8888, 1.2, 10000, "/resources/USDT.png");
                Criptomoneda cripto5 = new Criptomoneda('C', "Dogecoin", "DOGE", 8888, 0.7, 10000,
                                "/resources/DOGE.png");

                Fiat fiat1 = new Fiat('F', "Peso argentino", "ARS", 0.00098, "/resources/ARS.png");
                Fiat fiat2 = new Fiat('F', "Dolar", "USD", 1, "/resources/USD.png");

                dao.generarMoneda(cripto1);
                dao.generarMoneda(cripto2);
                dao.generarMoneda(cripto3);
                dao.generarMoneda(cripto4);
                dao.generarMoneda(cripto5);
                dao.generarMoneda(fiat1);
                dao.generarMoneda(fiat2);
        }
}
