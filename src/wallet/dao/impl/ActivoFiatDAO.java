package wallet.dao.impl;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import wallet.dao.interfaces.IActivoFiatDAO;
import wallet.model.entity.ActivoCripto;
import wallet.model.entity.ActivoFiat;

public class ActivoFiatDAO implements IActivoFiatDAO {
    private MonedaDAO m = new MonedaDAO();

    @Override
    public void generarActivoFiat(ActivoFiat activoFiat, int idUsuario, int idMoneda) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");

            if (activoExiste(c, idUsuario, idMoneda)) {
                actualizarActivo(c, idMoneda, idUsuario, activoFiat);
            } else {
                insertarActivo(c, activoFiat, idUsuario, idMoneda);
            }
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public boolean activoExiste(Connection c, int idUsuario, int idMoneda) throws SQLException {
        String sql = "SELECT CANTIDAD FROM ACTIVO_FIAT WHERE ID_MONEDA = ? AND ID_USUARIO = ?";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, idMoneda);
            pstmt.setInt(2, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void actualizarActivo(Connection c, int idMoneda, int idUsuario, ActivoFiat activo) throws SQLException {
        String sql = "UPDATE ACTIVO_FIAT SET CANTIDAD = CANTIDAD + ? WHERE ID_MONEDA = ? AND ID_USUARIO = ?";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setDouble(1, activo.getCantidad());
            pstmt.setInt(2, idMoneda);
            pstmt.setInt(3, idUsuario);
            pstmt.executeUpdate();
        }

    }

    public void insertarActivo(Connection c, ActivoFiat activo, int idUsuario, int idMoneda) throws SQLException {
        String sql = "INSERT INTO ACTIVO_FIAT (ID_MONEDA, CANTIDAD, ID_USUARIO) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = c.prepareStatement(sql)) {
            pstmt.setInt(1, idMoneda);
            pstmt.setDouble(2, activo.getCantidad());
            pstmt.setInt(3, idUsuario);
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<ActivoFiat> listarActivosFiat(int idUsuario) {
        Connection c = null;
        PreparedStatement stmt = null;
        List<ActivoFiat> activos = new LinkedList<>();
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            String query = "SELECT * FROM ACTIVO_FIAT WHERE ID_USUARIO = ?";
            stmt = c.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomenclatura = new MonedaDAO().obtenerNomenclatura(rs.getInt("ID_MONEDA"));
                ActivoFiat activo = new ActivoFiat(rs.getDouble("CANTIDAD"), nomenclatura);
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
        String sql = "SELECT COUNT(*) FROM ACTIVO_FIAT WHERE ID_MONEDA = ? AND ID_USUARIO = ? AND CANTIDAD >= ?";
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
