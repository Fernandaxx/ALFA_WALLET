package wallet.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import wallet.model.entity.ActivoFiat;

/**
 * Interfaz que define los métodos para gestionar la persistencia de activos
 * fiduciarios en una base de datos.
 */
public interface IActivoFiatDAO {

    /**
     * Genera un nuevo activo fiduciario en la base de datos.
     *
     * @param activoFiat El activo fiduciario a generar.
     * @return true si la operación fue exitosa; false en caso contrario.
     */
    void generarActivoFiat(ActivoFiat activoFiat, int idUsuario, int idMoneda);

    /**
     * Lista todos los activos fiduciarios en la base de datos.
     *
     * @return Una lista de activos fiduciarios.
     */
    List<ActivoFiat> listarActivosFiat(int idUsuario);

    /**
     * Verifica si un activo fiduciario ya existe en la base de datos.
     *
     * @param c            La conexión a la base de datos.
     * @param nomenclatura La nomenclatura del activo fiduciario a verificar.
     * @return true si el activo existe; false en caso contrario.
     * @throws SQLException Si ocurre un error durante la verificación.
     */
    boolean activoExiste(Connection c, int idUsuario, int idMoneda) throws SQLException;

    /**
     * Actualiza un activo fiduciario existente en la base de datos.
     *
     * @param c      La conexión a la base de datos.
     * @param activo El activo fiduciario a actualizar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    void actualizarActivo(Connection c, int idMoneda, int idUsuario, ActivoFiat activo) throws SQLException;

    /**
     * Inserta un nuevo activo fiduciario en la base de datos.
     *
     * @param c      La conexión a la base de datos.
     * @param activo El activo fiduciario a insertar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    void insertarActivo(Connection c, ActivoFiat activo, int idUsuario, int idMoneda) throws SQLException;

    /**
     * Verifica si hay suficiente cantidad de un activo fiduciario en la base de
     * datos.
     *
     * @param c            La conexión a la base de datos.
     * @param nomenclatura La nomenclatura del activo fiduciario.
     * @param cantidad     La cantidad a verificar.
     * @return true si hay suficiente cantidad; false en caso contrario.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    boolean verificarCantidad(Connection c, int idUsuario, int idMoneda, double cantidad) throws SQLException;

}
