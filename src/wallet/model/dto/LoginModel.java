package wallet.model.dto;

import wallet.dao.impl.UsuarioDAO;
import wallet.model.entity.Usuario;

public class LoginModel {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public LoginModel() {

    }

    public boolean permitirAcceso(String email, String password) {
        Usuario usuario = usuarioDAO.buscarUsuario(email);
        if (usuario == null) {
            System.out.println("usuario no registrado 'mensaje para controlador'");
            return false;
        }
        if (!usuario.getPassword().equals(password)) {
            System.out.println("contraseña incorrecta ' mensaje para controlador'");
            return false;
        }
        return true;
    }

}
