package wallet;

import java.nio.channels.ByteChannel;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.LinkedList;

import wallet.dao.impl.*;
import wallet.model.entity.*;

public class CARGAR {
    public static void main(String[] args) {
        // Crear instancia del DAO
        //TransaccionDAO dao = new TransaccionDAO();
        //ActivoCriptoDAO daoCripto = new ActivoCriptoDAO();
        

       MonedaDAO dao = new MonedaDAO();
                Criptomoneda cripto1 = new Criptomoneda('C', "Bitcoin", "BTC", 8888, 0.5, 100, "/resources/BTC.png");
                Criptomoneda cripto2 = new Criptomoneda('C', "Ethereum", "ETH", 8888, 0.6, 1000, "/resources/ETH.png");
                Criptomoneda cripto3 = new Criptomoneda('C', "Usdc", "USDC", 8888, 0.1, 1000, "/resources/USDC.png");
                Criptomoneda cripto4 = new Criptomoneda('C', "Tether", "USDT", 8888, 1.2, 1, "/resources/USDT.png");
                Criptomoneda cripto5 = new Criptomoneda('C', "Dogecoin", "DOGE", 8888, 0.7, 10, "/resources/DOGE.png");

                Fiat fiat1 = new Fiat('F', "Peso argentino", "ARS", 0.00098, "/resources/ARS.png");
                Fiat fiat2 = new Fiat('F', "Dolar", "USD", 1, "/resources/USD.png");

                dao.generarMoneda(cripto1);
                dao.generarMoneda(cripto2);
                dao.generarMoneda(cripto3);
                dao.generarMoneda(cripto4);
                dao.generarMoneda(cripto5);
                dao.generarMoneda(fiat1);
                dao.generarMoneda(fiat2);      
    }
}
