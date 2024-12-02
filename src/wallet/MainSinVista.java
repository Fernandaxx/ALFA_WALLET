package wallet;

import wallet.config.DataBaseConfig;
import wallet.controller.SignUpController;

import wallet.view.SignUpView;

public class MainSinVista {

    public static void main(String[] args) {
        DataBaseConfig dataBase = new DataBaseConfig();
        dataBase.CreateDatabase();

        SignUpController controller = new SignUpController();
        SignUpView view = new SignUpView();

        while (true) {
            int opcion = view.mostrarMenu();

            switch (opcion) {
                case 1:
                    String[] credenciales = view.solicitarCredenciales();
                    controller.registrarUsuario(credenciales);

                    break;
                case 3:
                    view.mostrarMensaje("Gracias por usar el sistema");
                    System.exit(0);

                default:
                    view.mostrarMensaje("Opción inválida");
            }
        }
    }
}
