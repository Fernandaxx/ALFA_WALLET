package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.dto.LoginModel;
import wallet.model.entity.Usuario;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.InicialFrame;
import wallet.view.vistas.LoginView;

public class LoginController {
    private LoginView view;
    private LoginModel model;
    private InicialFrame mainFrame;

    public LoginController(LoginView view, LoginModel model, InicialFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.getButton().addActionListener(new LoginAction());

    }

    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            String password = view.getPassword();
            if (!(email.isEmpty() || password.isEmpty())) {
                Usuario usuario = model.usuarioRegistrado(email);
                if (usuario != null) {
                    if (model.correctPassword(email, password)) {
                        view.showMessage("Bienvenido");
                        mainFrame.dispose();
                        CentralFrame.main(usuario.getPersona().getNombre());

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
