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
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean permitirRegistro() {
        if (usuarioDAO.buscarUsuario(this.usuario.getEmail()) != null) {
            System.out.println("Usuario ya registrado");
            return false;
        }
        if (!usuario.getAceptaTerminos()) {
            System.out.println("El usuario no acepta los términos");
            return false;
        }
        return true;
    }

    public boolean registrarUsuario() {
        System.out.println("llega");
        if (permitirRegistro()) {
            new PersonaDAO().crearPersona(usuario.getPersona());
            usuarioDAO.crearUsuario(usuario);
            return true;
        } else {
            return false;
        }
    }
}