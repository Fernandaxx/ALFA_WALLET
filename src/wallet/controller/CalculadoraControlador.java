package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.model.dto.CalculadoraModelo;
import wallet.view.CalculadoraVista;

public class CalculadoraControlador {
    private CalculadoraModelo modelo;
    private CalculadoraVista vista;

    public CalculadoraControlador(CalculadoraModelo modelo, CalculadoraVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        // Asigna el controlador al botón de la vista
        this.vista.getBotonMultiplicar().addActionListener(new MultiplicarListener());
    }

    // Clase interna que implementa la acción de multiplicación
    class MultiplicarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int numero1 = vista.getNumero1();
                int numero2 = vista.getNumero2();
                // Llamada al modelo para realizar la operación
                int resultado = modelo.multiplicar(numero1, numero2);
                // Actualiza la vista con el resultado
                vista.setResultado(resultado);
            } catch (NumberFormatException ex) {
                vista.mostrarMensajeError("Por favor ingrese números válidos.");
            }
        }
    }
}
