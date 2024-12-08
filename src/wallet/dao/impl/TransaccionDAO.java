package wallet.dao.impl;

import java.sql.*;
import java.time.LocalDateTime;
import wallet.dao.interfaces.ITransaccionDAO;
import wallet.model.entity.Transaccion;
import wallet.model.entity.Compra;
import java.util.*;

/**
 * La clase TransaccionDAO proporciona métodos para registrar y borrar
 * transacciones
 * en la base de datos de la billetera virtual. Implementa la interfaz
 * ITransaccionDAO.
 * 
 * @author Grupo13
 * @version 1.0
 * @since 2024
 */
public class TransaccionDAO implements ITransaccionDAO {

    /**
     * Registra una nueva transacción en la base de datos.
     *
     * @param c           La conexión a la base de datos.
     * @param transaccion La transacción a registrar.
     */
    public void registrarTransaccion(Connection c, Transaccion transaccion, int idCuenta) {
        try {
            String sql = "INSERT INTO TRANSACCION (RESUMEN, FECHA_HORA,ID_CUENTA) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(1, transaccion.getResumen());
                pstmt.setTimestamp(2, Timestamp.valueOf(transaccion.getFecha()));
                pstmt.setInt(3,idCuenta);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * Elimina una transacción de la base de datos utilizando su fecha y hora.
     *
     * @param fecha La fecha y hora de la transacción a borrar.
     * @throws RuntimeException si no se encuentra una transacción con la fecha
     *                          especificada.
     */
    @Override
    public void borrarTransaccion(LocalDateTime fecha) {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            System.out.println("Opened database successfully");

            String sql = "DELETE FROM TRANSACCION WHERE FECHA_HORA = ?";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setTimestamp(1, Timestamp.valueOf(fecha));
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas == 0) {

                throw new RuntimeException("No se encontró una transacción en: " + fecha);
            }
            pstmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Operation done successfully");
    }

    public List<Transaccion> listarTransacciones(int idCuenta){
        List<Transaccion> lista = new LinkedList<>();
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            c.createStatement();
            String sql = "SELECT * FROM TRANSACCION WHERE ID_CUENTA = ? ";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, idCuenta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                lista.add( new Compra(rs.getTimestamp("FECHA_HORA").toLocalDateTime() , rs.getString("RESUMEN")));
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        return lista;
    }

}