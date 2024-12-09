package wallet;

import java.nio.channels.ByteChannel;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.LinkedList;

import wallet.dao.impl.*;
import wallet.model.entity.Moneda;
import wallet.model.entity.*;

public class CARGAR {
    public static void main(String[] args) {
        // Crear instancia del DAO
        //TransaccionDAO dao = new TransaccionDAO();
        MonedaDAO dao = new MonedaDAO();
        Criptomoneda cripto1 = new Criptomoneda('C', "Bitcoin", "BTC", 8888, 0.5, 10000, "wallet/resources/BTC.png");
        Criptomoneda cripto2 = new Criptomoneda('C', "Ethereum", "ETH", 8888, 0.6, 10000, "wallet/resources/ETH.png");
        Criptomoneda cripto3 = new Criptomoneda('C', "Usdc", "USDC", 8888, 0.1, 10000, "wallet/resources/USDC.png");
        Criptomoneda cripto4 = new Criptomoneda('C', "Tether", "USDT", 8888, 1.2, 10000, "wallet/resources/USDT.png");
        Criptomoneda cripto5 = new Criptomoneda('C', "Dogecoin", "DOGE", 8888, 0.7, 10000, "wallet/resources/DOGE.png");

        dao.generarMoneda(cripto1);
        dao.generarMoneda(cripto2);
        dao.generarMoneda(cripto3);
        dao.generarMoneda(cripto4);
        dao.generarMoneda(cripto5);

       /*Compra compra = new Compra(LocalDateTime.now(),"Compra de ETH");
        int idUsuario = 1;
        // Establecer la conexión con la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db")) {
            // Registrar la transacción
            dao.registrarTransaccion(connection, compra, idUsuario);
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
