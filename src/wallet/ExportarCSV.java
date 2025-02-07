package wallet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import wallet.model.entity.ActivoCripto;
import wallet.model.entity.ActivoFiat;

public class ExportarCSV {

    public int exportarActivos(String nombreArchivo, List<ActivoCripto> activosC, List<ActivoFiat> activosF) {
        int res = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezado del archivo
            writer.write("Moneda,Monto");
            writer.newLine();

            // Escribir cada transacción como una línea en el CSV
            for (ActivoCripto a : activosC) {
                writer.write(a.getCripto().getNombre() + "," + a.getCantidad());
                writer.newLine();
            }
            for (ActivoFiat a : activosF) {
                writer.write(a.getFiat().getNombre() + "," + a.getCantidad());
                writer.newLine();
            }
            return res;

        } catch (IOException e) {
            res = -1;
            System.err.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
        return res;
    }
}
