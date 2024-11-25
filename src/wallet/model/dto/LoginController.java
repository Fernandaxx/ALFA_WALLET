package wallet.model.dto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.entity.Usuario;
import wallet.view.LoginView;

public class LoginController {
    private Usuario model;
    private LoginView view;

    public LoginController(Usuario model, LoginView view) {
        this.model = model;
        this.view = view;

        // Configurar listener
        view.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = view.getEmail();
                String password = view.getPassword();

                if (model.autenticar(email, password)) {
                    view.setMensaje("Login exitoso");
                    // Abrir dashboard o siguiente pantalla
                } else {
                    view.setMensaje("Credenciales incorrectas");
                }
            }
        });
    }

    public void iniciarLogin() {
        view.setVisible(true);
    }
}