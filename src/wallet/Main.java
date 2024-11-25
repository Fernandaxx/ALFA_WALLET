package wallet;

import wallet.config.DataBaseConfig;
import wallet.model.dto.LoginController;
import wallet.model.entity.Usuario;
import wallet.view.LoginView;

public class Main {

    public static void main(String[] args) {
        DataBaseConfig dataBase = new DataBaseConfig();
        dataBase.CreateDatabase();
        // Usar SwingUtilities para manejar eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            Usuario model = new Usuario();
            LoginView view = new LoginView();
            LoginController controller = new LoginController(model, view);
            controller.iniciarLogin();
        });
    }
}
