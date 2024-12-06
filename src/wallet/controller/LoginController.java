package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.dto.LoginModel;
import wallet.view.LoginView;

public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;

        view.getButton().addActionListener(new LoginAction());

    }

    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            String password = view.getPassword();
            if (!(email.isEmpty() || password.isEmpty())) {
                if (model.usuarioRegistrado(email)) {
                    if (model.correctPassword(email, password)) {
                        view.showMessage("Bienvenido");

                    } else {
                        view.showMessage("Contraseña incorrecta");
                        return;
                    }
                } else {
                    view.showMessage("Usuario no registrado");
                    return;
                }
            } else {
                view.showMessage("Verifique que todos los campos esten llenos");
                return;
            }
        }
    }
}
