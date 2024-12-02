package wallet.view;

import java.util.Scanner;

public class SignUpView {
    // metodo

    private Scanner scanner;

    public SignUpView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- Sistema de Registro ---");
        System.out.println("1. Registrar Usuario");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public String[] solicitarCredenciales() {
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        System.out.print("¿Acepta los términos y condiciones? (s/n)");
        String aceptaTerminos = scanner.nextLine();

        return new String[] { nombre, apellido, email, password, aceptaTerminos };
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
