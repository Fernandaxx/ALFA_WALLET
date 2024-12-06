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

        view.getCmd().addActionListener(new LoginAction());

    }

    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            String password = view.getPassword();
            if (email.isEmpty() || password.isEmpty()) {
                // Message.show("Please fill in all fields", "Warning",
                // JOptionPane.WARNING_MESSAGE);
            } else {
                if (model.permitirAcceso(email, password)) {
                    view.dispose();
                } else {
                    // Message.show("Invalid email or password", "Warning",
                    // JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

}