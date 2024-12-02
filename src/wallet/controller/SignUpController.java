package wallet.controller;

import wallet.model.dto.SignUpModel;
import wallet.model.entity.Persona;
import wallet.model.entity.Usuario;
import wallet.view.SignUpView;

public class SignUpController {
    private SignUpModel signUpModel;
    private SignUpView signUpView = new SignUpView();

    public void registrarUsuario(String[] credenciales) {
        signUpModel = new SignUpModel(new Usuario(new Persona(credenciales[0], credenciales[1]), credenciales[2],
                credenciales[3], credenciales[4].equals("s")));
        if (signUpModel.registrarUsuario()) {
            signUpView.mostrarMensaje("Usuario registrado con éxito");
        } else {
            signUpView.mostrarMensaje("No se pudo registrar el usuario");
        }
    }

}
