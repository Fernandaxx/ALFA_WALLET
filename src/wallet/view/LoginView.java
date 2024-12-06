package wallet.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class LoginView extends JPanel {
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private Button cmd;

    public LoginView() {
        setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("INICIAR SESION");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(158, 5, 158));
        add(label);

        txtEmail = new MyTextField();

        txtEmail.setHint("E-mail");
        add(txtEmail, "w 60%");

        txtPass = new MyPasswordField();

        txtPass.setHint("Contraseña");
        add(txtPass, "w 60%");

        cmd = new Button();
        cmd.setBackground(new Color(158, 5, 158));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("LOGIN");
        add(cmd, "w 40%, h 40");

    }

    // Métodos públicos para interactuar con la vista
    public String getEmail() {
        return txtEmail.getText().trim();
    }

    public String getPassword() {
        return new String(txtPass.getPassword()).trim();
    }

    public Button getCmd() {
        return cmd;
    }

}
