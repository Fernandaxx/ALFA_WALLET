package wallet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.demo.FlatLafDemo;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;

import java.awt.*;
import java.awt.event.*;

public class BilleteraDesign extends JFrame {

    // Colores personalizados
    private static final Color COLOR_PRIMARIO = new Color(39, 150, 243); // Azul Material
    private static final Color COLOR_SECUNDARIO = new Color(63, 81, 181); // Índigo
    private static final Color COLOR_FONDO = new Color(238, 238, 238);

    // Fuentes personalizadas
    private static final Font FUENTE_TITULO = new Font("Roboto", Font.BOLD, 24);
    private static final Font FUENTE_NORMAL = new Font("Roboto", Font.PLAIN, 14);

    public BilleteraDesign() {
        cambiarTema("dark"); // Aplicar tema por defecto
        configurarVentanaPrincipal();
        crearMenuPersonalizado();
        crearPanelDashboard();
    }

    private void configurarVentanaPrincipal() {
        // Configuración de look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Billetera Virtual");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(COLOR_FONDO);
    }

    private void crearMenuPersonalizado() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(COLOR_PRIMARIO);
        menuBar.setForeground(Color.WHITE);

        // Menús personalizados
        JMenu menuInicio = new JMenu("Inicio");
        JMenu menuTransacciones = new JMenu("Transacciones");
        JMenu menuCartera = new JMenu("Cartera");
        JMenu menuConfiguracion = new JMenu("Configuración");

        // Personalizar apariencia de menús
        menuInicio.setFont(FUENTE_NORMAL);
        menuTransacciones.setFont(FUENTE_NORMAL);
        menuCartera.setFont(FUENTE_NORMAL);
        menuConfiguracion.setFont(FUENTE_NORMAL);

        menuBar.add(menuInicio);
        menuBar.add(menuTransacciones);
        menuBar.add(menuCartera);
        menuBar.add(menuConfiguracion);

        setJMenuBar(menuBar);

        JMenuItem itemTemaClaro = new JMenuItem("Tema Claro");
        itemTemaClaro.addActionListener(e -> cambiarTema("light"));

        JMenuItem itemTemaOscuro = new JMenuItem("Tema Oscuro");
        itemTemaOscuro.addActionListener(e -> cambiarTema("dark"));

        JMenuItem itemTemaArc = new JMenuItem("Tema Arc Dark");
        itemTemaArc.addActionListener(e -> cambiarTema("arc"));

        menuConfiguracion.add(itemTemaClaro);
        menuConfiguracion.add(itemTemaOscuro);
        menuConfiguracion.add(itemTemaArc);
    }

    private void crearPanelDashboard() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel de resumen
        JPanel panelResumen = crearPanelResumen();

        // Tabla de activos
        JTable tablaActivos = crearTablaActivos();

        // Gráfico de distribución
        JPanel panelGrafico = crearPanelGrafico();

        // Organizar componentes
        panelPrincipal.add(panelResumen, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(tablaActivos), BorderLayout.CENTER);
        panelPrincipal.add(panelGrafico, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private JPanel crearPanelResumen() {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_PRIMARIO);

        JLabel lblSaldoTotal = new JLabel("Saldo Total: $10,000.00");
        lblSaldoTotal.setFont(FUENTE_TITULO);
        lblSaldoTotal.setForeground(Color.WHITE);

        panel.add(lblSaldoTotal);
        return panel;
    }

    private JTable crearTablaActivos() {
        String[] columnNames = { "Activo", "Cantidad", "Valor", "% Cambio" };
        Object[][] data = {
                { "Bitcoin", "0.5", "$25,000", "+5.2%" },
                { "Ethereum", "2.3", "$4,500", "-1.7%" },
                { "USDT", "1000", "$1,000", "0.0%" }
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable tabla = new JTable(model);

        // Personalizar tabla
        tabla.setFont(FUENTE_NORMAL);
        tabla.setRowHeight(30);
        tabla.getTableHeader().setFont(FUENTE_NORMAL);

        return tabla;
    }

    private JPanel crearPanelGrafico() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setBackground(Color.WHITE);

        JLabel lblGrafico = new JLabel("Gráfico de Distribución de Activos");
        lblGrafico.setFont(FUENTE_NORMAL);

        panel.add(lblGrafico);
        return panel;
    }

    // Método de diálogo personalizado
    public void mostrarDialogo(String mensaje, boolean esError) {
        JOptionPane optionPane = new JOptionPane(mensaje,
                esError ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Billetera Virtual");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    private void cambiarTema(String tipoTema) {
        try {
            switch (tipoTema) {
                case "light":
                    FlatLightLaf.setup();
                    break;
                case "dark":
                    FlatDarkLaf.setup();
                    break;
                case "arc":
                    FlatArcDarkIJTheme.setup();
                    break;
            }
            // Actualizar toda la ventana
            SwingUtilities.updateComponentTreeUI(this);
            actualizarMenuBar();
            // Revalidar y repintar
            this.invalidate();
            this.validate();
            this.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void actualizarMenuBar() {
        JMenuBar menuBar = getJMenuBar();
        menuBar.setBackground(COLOR_PRIMARIO);
        menuBar.setForeground(Color.WHITE);
        menuBar.repaint();
    }

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel(new FlatArcDarkIJTheme());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilleteraDesign().setVisible(true);
            }
        });
    }
}