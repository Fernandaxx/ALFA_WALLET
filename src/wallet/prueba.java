package wallet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import wallet.model.entity.*;
import wallet.dao.impl.*;

public class prueba {
    public static void main(String[] args) {
        // Lista de transacciones de ejemplo
        TransaccionDAO dao = new TransaccionDAO();
        List<Transaccion> transacciones = dao.listarTransacciones(1);
        
        // Exportar a CSV
        ExportarCSV.exportarTransacciones("transacciones.csv", transacciones);
    }
}


