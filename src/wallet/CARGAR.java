package wallet;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.LinkedList;

import wallet.dao.impl.*;
import wallet.model.entity.Compra;

public class CARGAR {
    public static void main(String[] args) {
        // Crear instancia del DAO
        TransaccionDAO dao = new TransaccionDAO();

       Compra compra = new Compra(LocalDateTime.now(),"Compra de BTC");
        int idCuenta = 2;
        // Establecer la conexión con la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db")) {
            // Registrar la transacción
            dao.registrarTransaccion(connection, compra, idCuenta);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
