package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import wallet.model.dto.SignUpModel;
import wallet.model.entity.Persona;
import wallet.model.entity.Usuario;
import wallet.view.vistas.SignUpView;
import wallet.exception.CamposIncException;
import wallet.exception.TyCException;
import wallet.exception.UsuarioRegException;

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

            try {
                if (!tyc) {
                    throw new TyCException();
                }
                if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    throw new CamposIncException();
                } else {
                    Registrar(name, lastName, email, password, tyc);
                    if (model.usuarioRegistrado()) {
                        throw new UsuarioRegException(email);
                    } else {
                        if (model.registrarUsuario()) {
                            view.showMessage("Registro exitoso");
                        } else {
                            view.showMessage("Error al registrar usuario");
                        }
                    }

                }
            } catch (TyCException ex) {
                view.showMessage(ex.getMessage());
            } catch (CamposIncException ex) {
                view.showMessage(ex.getMessage());
            } catch (UsuarioRegException ex) {
                view.showMessage(ex.getMessage());
            }
        }

        private void Registrar(String name, String lastName, String email, String password, boolean tyc) {
            Persona persona = new Persona(name, lastName);
            Usuario usuario = new Usuario();
            usuario.setPersona(persona);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setAceptaTerminos(tyc);
            model.setUsuario(usuario);
        }
    }
}
