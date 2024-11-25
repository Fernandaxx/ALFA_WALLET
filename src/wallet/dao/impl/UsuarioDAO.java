package wallet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import wallet.dao.interfaces.IUsuarioDAO;
import wallet.model.entity.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public boolean crearUsuario(Usuario usuario) {
        boolean exito = true;
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            String sql = "INSERT INTO USUARIO (ID_PERSONA, EMAIL, PASSWORD, ACEPTA_TERMINOS) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setInt(1, usuario.getId_Persona());
                pstmt.setString(2, usuario.getEmail());
                pstmt.setString(3, usuario.getPassword());
                pstmt.setBoolean(4, usuario.getAceptaTerminos());
                pstmt.executeUpdate();
            }
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        return exito;
    }

    @Override
    public Usuario buscarUsuario(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUsuario'");
    }

    @Override
    public void actualizarUsuario(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarUsuario'");
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarUsuario'");
    }

}
