package wallet.model.dto;

import wallet.dao.impl.UsuarioDAO;
import wallet.model.entity.Usuario;

public class LoginModel {
    private String email;
    private String password;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean permitirAcceso() {
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
