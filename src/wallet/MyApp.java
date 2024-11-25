package wallet;

import javax.swing.*;
import java.awt.*;

public class MyApp extends JFrame {

    public MyApp() {
        // Configuración básica de la ventana
        setTitle("Mi Aplicación");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar componentes
        initComponents();
    }

    private void initComponents() {
        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Ejemplo: Agregar un botón
        JButton btnEjemplo = new JButton("Haz clic");
        mainPanel.add(btnEjemplo, BorderLayout.CENTER);

        // Agregar el panel principal al frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MyApp app = new MyApp();
            app.setVisible(true);
        });
    }
}
