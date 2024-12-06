package wallet.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.MyCheckbox;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class SignUpView extends JPanel {

    private MyTextField txtName;
    private MyTextField txtEmail;
    private MyTextField txtLastName;
    private MyPasswordField txtPass;
    private Button cmd;
    private MyCheckbox tyc;

    public SignUpView() {
        setLayout(new MigLayout("wrap", "push[center]push", "push[]30[]10[]10[]10[]10[]25[]push"));
        JLabel label = new JLabel("CREAR CUENTA");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(158, 5, 158));
        add(label);

        txtName = new MyTextField();

        txtName.setHint("Nombre");
        add(txtName, "w 60%");

        txtLastName = new MyTextField();
        txtLastName.setHint("Apellido");
        add(txtLastName, "w 60%");

        txtEmail = new MyTextField();

        txtEmail.setHint("E-mail");
        add(txtEmail, "w 60%");

        txtPass = new MyPasswordField();

        txtPass.setHint("Contraseña");
        add(txtPass, "w 60%");

        tyc = new MyCheckbox();
        tyc.setText("Acepto los términos y condiciones");
        add(tyc, "gapbottom 20, wrap");

        cmd = new Button();
        cmd.setBackground(new Color(158, 5, 158));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        add(cmd, "w 40%, h 40");

    }

    public Button getBoton() {
        return cmd;
    }

    public String getUserName() {
        return txtName.getText().trim();
    }

    public String getEmail() {
        return txtEmail.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

}