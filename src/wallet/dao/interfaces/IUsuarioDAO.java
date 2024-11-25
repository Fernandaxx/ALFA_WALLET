package wallet.dao.interfaces;

import wallet.model.entity.Usuario;
/**
 * La interfaz IUsuarioDAO define los métodos necesarios para gestionar
 * los usuarios en la base de datos. Proporciona operaciones para registrar o
 * verificar usuarios.
 * 
 * @author Grupo13
 * @version 1.0
 * @since 2024
 */

public interface IUsuarioDAO {
    boolean verificarUsuario(String email, String contraseña);

    void registrarUsuario(Usuario usuario);

}
