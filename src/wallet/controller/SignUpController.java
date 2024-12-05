package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import wallet.model.dto.SignUpModel;
import wallet.model.entity.Persona;
import wallet.model.entity.Usuario;
import wallet.view.SignUpView;

public class SignUpController {
    private SignUpView view;
    private SignUpModel model;

    public SignUpController(SignUpView view, SignUpModel model) {
        this.view = view;
        this.model = model;

        view.addSignUpListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getName();
                // String surname = view.getSurname();
                String email = view.getEmail();
                String password = view.getPassword();
                // boolean acceptTerms = view.isAcceptTerms();
                // || surname.isEmpty()
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    view.showMessage("Todos los campos son obligatorios.");
                    return;
                }

                // if (!acceptTerms) {
                // view.showMessage("Debe aceptar los términos.");
                // return;
                // }

                Persona persona = new Persona();
                persona.setNombre(name);
                // persona.setApellido(surname);

                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setPassword(password);
                // usuario.setAceptaTerminos(acceptTerms);
                usuario.setPersona(persona);

                model.setUsuario(usuario);

                if (model.registrarUsuario()) {
                    view.showMessage("Registro exitoso.");
                    // mainFrame.mostrarLogin();
                } else {
                    view.showMessage("Error en el registro.");
                }
            }
        });
    }
}