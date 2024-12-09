package wallet.dao.interfaces;

import java.sql.*;
import java.util.List;
import wallet.model.entity.ActivoCripto;

/**
 * Interfaz que define los métodos para gestionar la persistencia de activos
 * cripto en una base de datos.
 */
public interface IActivoCriptoDAO {

    /**
     * Genera un nuevo activo cripto en la base de datos.
     *
     * @param activoCripto El activo cripto a generar.
     * @return true si la operación fue exitosa; false en caso contrario.
     */
    void generarActivoCripto(ActivoCripto activo, int idUsuario, int IdMoneda);

    /**
     * Lista todos los activos cripto en la base de datos por id de usuario.
     *
     * @return Una lista de activos cripto.
     */
    List<ActivoCripto> listarActivosCripto(int idUsuario, String nomenclatura);

    /**
     * Verifica si un activo cripto ya existe en la base de datos.
     *
     * @param c            La conexión a la base de datos.
     * @param nomenclatura La nomenclatura del activo cripto a verificar.
     * @return true si el activo existe; false en caso contrario.
     * @throws Exception Si ocurre un error durante la verificación.
     */
    boolean activoExiste(Connection c, int idUsuario, int idMoneda) throws Exception;

    /**
     * Actualiza un activo cripto existente en la base de datos.
     *
     * @param c      La conexión a la base de datos.
     * @param activo El activo cripto a actualizar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    void actualizarActivo(Connection c, int idMoneda, int idUsuario, ActivoCripto activo) throws SQLException;

    /**
     * Inserta un nuevo activo cripto en la base de datos.
     *
     * @param c      La conexión a la base de datos.
     * @param activo El activo cripto a insertar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    void insertarActivo(Connection c, ActivoCripto activo, int idUsuario, int idMoneda) throws SQLException;

    /**
     * Verifica si hay suficiente cantidad de un activo cripto en la base de
     * datos.
     *
     * @param c            La conexión a la base de datos.
     * @param nomenclatura La nomenclatura del activo cripto.
     * @param cantidad     La cantidad a verificar.
     * @return true si hay suficiente cantidad; false en caso contrario.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    boolean verificarCantidad(Connection c, int idUsuario, int idMoneda, double cantidad) throws SQLException;

}