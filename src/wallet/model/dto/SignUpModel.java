package wallet.model.dto;

import wallet.dao.impl.PersonaDAO;
import wallet.dao.impl.UsuarioDAO;
import wallet.model.entity.Usuario;

public class SignUpModel {
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public SignUpModel(Usuario usuario) {
        this.usuario = usuario;
    }

    public SignUpModel() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean permitirRegistro() {
        if (usuarioDAO.buscarUsuario(this.usuario.getEmail()) != null) {
            System.out.println("usuario registrado");
            return false;
        }
        if (!usuario.getAceptaTerminos()) {
            System.out.println("usuario no acepta terminos");
            return false;
        }
        return true;
    }

    public boolean registrarUsuario() {
        if (permitirRegistro()) {
            new PersonaDAO().crearPersona(usuario.getPersona());
            usuarioDAO.crearUsuario(usuario);
            return true;
        } else {
            return false;
        }
    }

}
