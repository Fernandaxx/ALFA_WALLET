package wallet;

import wallet.controller.LoginController;
import wallet.model.entity.Usuario;
import wallet.view.LoginView;

import javax.swing.UIManager;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import wallet.config.DataBaseConfig;

public class Main {

    public static void main(String[] args) {
        DataBaseConfig dataBase = new DataBaseConfig();
        dataBase.CreateDatabase();
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());

        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario model = new Usuario();
                LoginView view = new LoginView();
                // LoginController controller = new LoginController(model, view);
                // controller.iniciarLogin();

            }
        });
    }

}
