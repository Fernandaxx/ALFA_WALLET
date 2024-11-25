package wallet.view;

import javax.swing.*;
import java.awt.*;

public class CalculadoraVista extends JFrame {
    private JTextField campoNumero1 = new JTextField(10);
    private JTextField campoNumero2 = new JTextField(10);
    private JButton botonMultiplicar = new JButton("Multiplicar");
    private JTextField campoResultado = new JTextField(10);

    public CalculadoraVista() {
        setTitle("Calculadora MVC Multiplicación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 5));
        add(new JLabel("Número 1 :"));
        add(new JLabel(""));
        add(campoNumero1);
        add(new JLabel("Número 2:"));
        add(campoNumero2);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel("Resultado:"));
        add(botonMultiplicar);
        add(campoResultado);
        add(new JLabel(""));
        add(new JLabel(""));
        campoResultado.setEditable(false);
    }

    // getters para los campos y boton
    public int getNumero1() {
        return Integer.parseInt(campoNumero1.getText());
    }

    public int getNumero2() {
        return Integer.parseInt(campoNumero2.getText());
    }

    public void setResultado(int resultado) {
        campoResultado.setText(Integer.toString(resultado));
    }

    public JButton getBotonMultiplicar() {
        return botonMultiplicar;
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}