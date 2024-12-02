package wallet.view;

import java.awt.*;
import javax.swing.*;

public class SesionView extends JFrame {

    private JTextField mail = new JTextField(30);
    private JTextField contraseña = new JTextField(30);
    private JButton buttonIng = new JButton("Ingresar");
    private JTextField result = new JTextField(20);

    public SesionView() {
        setTitle("ALFA Wallet - Inicio Sesion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());

        add(new JLabel("Iniciar sesion"));
        add(new JLabel("email: "));
        add(mail);
        add(new JLabel("Contraseña: "));
        add(contraseña);
        add(buttonIng);

        result.setEditable(false);
    }

    public String getMail() {
        return mail.getText();
    }

    public String getContraseña() {
        return contraseña.getText();
    }

    public JButton getButtonIng() {
        return buttonIng;
    }

    public void setMensaje(String mensaje) {
        result.setText(mensaje);
    }

}
