package wallet.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel mensajeLabel;

    public LoginView() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        setTitle("ALFA WALLET - Login");
        setTitle("ALFA WALLET - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Iniciar Sesión");
        add(loginButton);

        mensajeLabel = new JLabel("");
        add(mensajeLabel);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setMensaje(String mensaje) {
        mensajeLabel.setText(mensaje);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
*/
import java.util.Scanner;

public class LoginView {
    private Scanner scanner;

    public LoginView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- Sistema de Login ---");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public String[] solicitarCredenciales() {
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        return new String[] { email, password };
    }

    public String solicitarNombre() {
        System.out.print("Ingrese su nombre (opcional): ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
