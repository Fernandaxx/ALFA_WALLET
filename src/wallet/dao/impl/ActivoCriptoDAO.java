package wallet.dao.impl;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import wallet.dao.interfaces.IActivoCriptoDAO;
import wallet.model.entity.ActivoCripto;

/**
 * Clase para gestionar la persistencia de activos criptomonedas en la base de
 * datos.
 * Implementa la interfaz {@link IActivoCriptoDAO} para las operaciones
 * relacionadas con la creación, actualización, eliminación y listado de activos
 * cripto.
 */
public class ActivoCriptoDAO implements IActivoCriptoDAO {

    /**
     * Genera un nuevo activo cripto o actualiza uno existente en la base de
     * datos.
     *
     * @param activoCripto El activo cripto a generar o actualizar.
     * @return true si la operación se realizó con éxito, false en caso contrario.
     */

    public void generarActivoCripto(ActivoCripto activo, int idUsuario, int IdMoneda) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");

            if (activoExiste(c, idUsuario, IdMoneda)) {
                actualizarActivo(c, IdMoneda, idUsuario, activo);
            } else {
                insertarActivo(c, activo, idUsuario, IdMoneda);
            }
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public boolean activoExiste(Connection c, int idUsuario, int idMoneda) throws SQLException {
        String sql = "SELECT CANTIDAD FROM ACTIVO_CRIPTO WHERE ID_MONEDA = ? AND ID_USUARIO = ?";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, idMoneda);
            pstmt.setInt(2, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void actualizarActivo(Connection c, int idMoneda, int idUsuario, ActivoCripto activo) throws SQLException {
        String sql = "UPDATE ACTIVO_CRIPTO SET CANTIDAD = CANTIDAD + ? WHERE ID_MONEDA = ? AND ID_USUARIO = ?";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setDouble(1, activo.getCantidad());
            pstmt.setInt(2, idMoneda);
            pstmt.setInt(3, idUsuario);
            pstmt.executeUpdate();
        }

    }

    public void insertarActivo(Connection c, ActivoCripto activo, int idUsuario, int idMoneda) throws SQLException {
        String sql = "INSERT INTO ACTIVO_CRIPTO (ID_MONEDA, CANTIDAD, ID_USUARIO) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, idMoneda);
            pstmt.setDouble(2, activo.getCantidad());
            pstmt.setInt(3, idUsuario);
            pstmt.executeUpdate();
        }
    }

    public List<ActivoCripto> listarActivosCripto(int idUsuario) {
        Connection c = null;
        PreparedStatement stmt = null;
        List<ActivoCripto> activos = new LinkedList<>();
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            String query = "SELECT * FROM ACTIVO_CRIPTO WHERE ID_USUARIO = ?";
            stmt = c.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomenclatura = new MonedaDAO().obtenerNomenclatura(rs.getInt("ID_MONEDA"));

                ActivoCripto activo = new ActivoCripto(rs.getDouble("CANTIDAD"), nomenclatura);
                activos.add(activo);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        return activos;
    }

    public boolean verificarCantidad(Connection c, int idUsuario, int idMoneda, double cantidad) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ACTIVO_CRIPTO WHERE ID_MONEDA = ? AND ID_USUARIO = ? AND CANTIDAD >= ?";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, idMoneda);
            pstmt.setInt(2, idUsuario);
            pstmt.setDouble(3, cantidad);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

}
