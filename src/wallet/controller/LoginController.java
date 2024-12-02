package wallet.controller;

import wallet.dao.impl.UsuarioDAO;

import wallet.model.entity.Usuario;

public class LoginController {
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean registrarUsuario(String email, String password) {
        Usuario nuevoUsuario = new Usuario(email, password);
        return usuarioDAO.crearUsuario(nuevoUsuario);
    }

    public Usuario iniciarSesion(String email, String password) {
        return usuarioDAO.autenticarUsuario(email, password);
    }
}