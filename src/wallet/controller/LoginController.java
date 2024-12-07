package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.Main;
import wallet.MainFrame;
import wallet.MainSystem;
import wallet.model.dto.LoginModel;
import wallet.view.LoginView;
import wallet.view.ModelUser;

public class LoginController {
    private LoginView view;
    private LoginModel model;
    private MainFrame mainFrame;

    public LoginController(LoginView view, LoginModel model, MainFrame mainFrame) {
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
                        MainSystem.main(new ModelUser(1, "fer", "f@gma", "123"));

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
