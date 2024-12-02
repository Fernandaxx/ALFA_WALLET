package wallet.controller;

import wallet.dao.impl.UsuarioDAO;
import wallet.model.dto.LoginModel;
import wallet.model.entity.Usuario;
import wallet.view.LoginView;

public class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController() {

    }

    public void iniciarLogin() {
        view = new LoginView();
        String[] datos = view.getDatos();
        model = new LoginModel(datos[0], datos[1]);
        if (model.permitirAcceso()) {
            view.mostrarMensaje("Acceso permitido");
        } else {
            view.mostrarMensaje("Acceso denegado");
        }
    }
}
