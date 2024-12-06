package wallet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wallet.dao.interfaces.IPersonaDAO;
import wallet.model.entity.Persona;

public class PersonaDAO implements IPersonaDAO {

    @Override
    public boolean crearPersona(Persona persona) {
        boolean exito = true;
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            String sql = "INSERT INTO PERSONA (NOMBRES , APELLIDOS ) VALUES (?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(1, persona.getNombre());
                pstmt.setString(2, persona.getApellido());
                pstmt.executeUpdate();
            }
            c.close();
        } catch (SQLException e) {
            System.out.println(": Error al CrearPersona ex" + e.getMessage());
        }
        return exito;
    }

    @Override
    public int buscarPersona(String nombre, String apellido) {
        String sql = "SELECT ID FROM PERSONA WHERE NOMBRES = ? AND APELLIDOS = ?";
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
                PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int ID = rs.getInt("ID");
                    return ID;
                }
            }
            c.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar persona" + e.getMessage());
        }
        return -1;
    }

    @Override
    public void actualizarPersona(String nombre, String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPersona'");
    }

    @Override
    // borrarPersona de la base de datos

    public void borrarPersona(int ID) {
        String sql = "DELETE FROM PERSONA WHERE ID = ?";
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
                PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar persona: " + e.getMessage());
        }
    }

    public Persona buscarPersonaPorId(int personaId) {
        String sql = "SELECT NOMBRES, APELLIDOS FROM PERSONA WHERE ID = ?";
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
                PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, personaId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Persona persona = new Persona();
                    persona.setNombre(rs.getString("NOMBRES"));
                    persona.setApellido(rs.getString("APELLIDOS"));
                    return persona;
                }
            }
        } catch (SQLException e) {
            System.out.println(": " + e.getMessage());
        }
        return null;
    }

}
