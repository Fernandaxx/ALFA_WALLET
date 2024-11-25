package wallet;

import wallet.controller.*;
import wallet.view.*;
import wallet.model.dto.*;

public class MyApp {
    public static void main(String[] args) {
        // Crear el modelo, la vista y el controlador
        CalculadoraModelo modelo = new CalculadoraModelo();
        CalculadoraVista vista = new CalculadoraVista();
        new CalculadoraControlador(modelo, vista);
        // mostrar la vista
        vista.setVisible(true);
    }
}
