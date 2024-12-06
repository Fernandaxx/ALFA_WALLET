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

    public boolean usuarioRegistrado() {
        if (usuarioDAO.buscarUsuario(this.usuario.getEmail()) != null) {
            return true;
        }
        return false;
    }

    public boolean registrarUsuario() {
        try {
            new PersonaDAO().crearPersona(usuario.getPersona());
            usuarioDAO.crearUsuario(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}