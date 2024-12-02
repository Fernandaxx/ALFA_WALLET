package wallet.dao.interfaces;

import wallet.model.entity.Persona;

public interface IPersonaDAO {
    /**
     * La interfaz IUsuarioDAO define los métodos necesarios para gestionar
     * los usuarios en la base de datos. Proporciona operaciones para registrar o
     * verificar usuarios.
     * 
     * @author Grupo13
     * @version 1.0
     * @since 2024
     */

    boolean crearPersona(Persona persona);

    // retorna el ID
    int buscarPersona(String nombre, String apellido);

    // Por si se ingreso algun dato mal
    void actualizarPersona(String nombre, String apellido);

    void borrarPersona(int id);

}
