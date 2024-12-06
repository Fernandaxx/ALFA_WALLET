package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import wallet.model.dto.SignUpModel;
import wallet.model.entity.Persona;
import wallet.model.entity.Usuario;
import wallet.view.ModelUser;
import wallet.view.SignUpView;
import wallet.view.components.Button;

public class SignUpController {
    private SignUpView view;
    private SignUpModel model;

    public SignUpController(SignUpView view, SignUpModel model) {
        this.view = view;
        this.model = model;
        System.out.println("aqui");
        view.getBoton().addActionListener(new SignUpAction());
    }

    class SignUpAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String name = view.getUserName();
            String email = view.getEmail();
            String pass = view.getPassword();
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                view.showMessage("All fields are required");
            } else {
                Persona persona = new Persona();
                persona.setNombre(name);
                persona.setEmail(email);
                Usuario user = new Usuario();
                user.setPersona(persona);
                user.setPassword(pass);
                model.signUp(user);
            }
        }
    }

}