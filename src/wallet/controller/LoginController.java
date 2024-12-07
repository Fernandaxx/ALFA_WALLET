package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.Main;
import wallet.model.dto.LoginModel;
import wallet.view.MainSystemborrar;
import wallet.view.ModelUserborrar;
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
                if (model.usuarioRegistrado(email)) {
                    if (model.correctPassword(email, password)) {
                        view.showMessage("Bienvenido");
                        mainFrame.dispose();
                        MainSystemborrar.main(new ModelUserborrar(1, "fer", "f@gma", "123"));

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
