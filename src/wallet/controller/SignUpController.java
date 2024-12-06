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
        view.getButton().addActionListener(new SignUpAction());
    }

    class SignUpAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNames();
            String lastName = view.getLastName();
            String email = view.getEmail();
            String password = view.getPassword();
            boolean tyc = view.getTermYCond();

            if (!tyc) {
                view.showMessage("Debe aceptar los términos y condiciones");
                return;
            }
            if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                view.showMessage("Verifique que todos los campos esten llenos");
                return;
            } else {
                Persona persona = new Persona(name, lastName);
                Usuario usuario = new Usuario();
                usuario.setPersona(persona);
                usuario.setEmail(email);
                usuario.setPassword(password);
                usuario.setAceptaTerminos(tyc);
                model.setUsuario(usuario);
                if (model.usuarioRegistrado()) {
                    view.showMessage("Usuario ya registrado");
                    return;
                }
                if (model.registrarUsuario()) {
                    view.showMessage("Registro exitoso");
                } else {
                    view.showMessage("Error al registrar usuario");
                }
            }
        }
    }

}