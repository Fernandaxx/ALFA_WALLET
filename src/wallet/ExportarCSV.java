package wallet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import wallet.model.entity.Transaccion;

public class ExportarCSV {

    public static void exportarTransacciones(String nombreArchivo, List<Transaccion> transacciones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezado del archivo
            writer.write("Fecha,Resumen");
            writer.newLine();

            // Escribir cada transacción como una línea en el CSV
            for (Transaccion t : transacciones) {
                writer.write(t.getFecha() + "," + t.getResumen());
                writer.newLine();
            }

            System.out.println("Archivo CSV exportado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
    }
}

