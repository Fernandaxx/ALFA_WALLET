package wallet.model.dto;

import wallet.dao.impl.UsuarioDAO;
import wallet.model.entity.Usuario;

public class LoginModel {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public LoginModel() {

    }

    public boolean usuarioRegistrado(String email) {
        Usuario usuario = usuarioDAO.buscarUsuario(email);
        if (usuario == null) {
            return false;
        }
        return true;
    }

    public boolean correctPassword(String email, String password) {
        Usuario usuario = usuarioDAO.buscarUsuario(email);
        if (usuario.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
