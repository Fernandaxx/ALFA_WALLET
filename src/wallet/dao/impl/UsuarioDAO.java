package wallet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wallet.dao.interfaces.IUsuarioDAO;
import wallet.model.entity.Persona;
import wallet.model.entity.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public boolean crearUsuario(Usuario usuario) {
        boolean exito = true;
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            String sql = "INSERT INTO USUARIO (ID_PERSONA, EMAIL, PASSWORD, ACEPTA_TERMINOS) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setInt(1, new PersonaDAO().buscarPersona(usuario.getPersona().getNombre(),
                        usuario.getPersona().getApellido()));
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
        String sql = "SELECT ID_PERSONA, EMAIL, PASSWORD, ACEPTA_TERMINOS FROM USUARIO WHERE EMAIL = ?";
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
                PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setEmail(rs.getString("EMAIL"));
                    usuario.setPassword(rs.getString("PASSWORD"));
                    usuario.setAceptaTerminos(rs.getBoolean("ACEPTA_TERMINOS"));
                    int personaId = rs.getInt("ID_PERSONA");
                    Persona persona = new PersonaDAO().buscarPersonaPorId(personaId);
                    usuario.setPersona(persona);

                    return usuario;
                }
            }
            c.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarUsuario(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarUsuario'");
    }

    @Override
    public void borrarUsuario(int ID) {
        String sql = "DELETE FROM USUARIO WHERE ID = ?";
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
                PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar persona: " + e.getMessage());
        }
    }

}
