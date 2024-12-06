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
        public void actionPerformed(ActionEvent e) {
            System.out.println("?");
            String name = view.getUserName();
            System.out.println(name);
            String email = view.getEmail();
            String password = view.getPassword();
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                // view.showMessage("Please fill in all fields");
            } else {
                Persona persona = new Persona(name, "Apellido");
                Usuario usuario = new Usuario();
                usuario.setPersona(persona);
                usuario.setEmail(email);
                usuario.setPassword(password);
                usuario.setAceptaTerminos(true);
                model.setUsuario(usuario);
                if (model.registrarUsuario()) {
                    // view.showMessage("Registration successful");
                } else {
                    // view.showMessage("Registration failed");
                }
            }
        }
    }

}