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

        view.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String email = view.getEmail();
                String password = view.getPassword();

                if (model.permitirAcceso(email, password)) {
                    view.showMessage("Login Exitoso");
                    // Aquí podrías abrir la siguiente ventana
                } else {
                    view.showMessage("Credenciales Inválidas");
                }
            }
        });
    }
}