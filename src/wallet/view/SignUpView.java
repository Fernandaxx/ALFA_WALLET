package wallet.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class SignUpView extends JPanel {

    private MyTextField txtUser;
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private ModelUser user;
    private Button cmd;

    public SignUpView() {
        setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        add(label);

        txtUser = new MyTextField();
        // txtUser.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
        txtUser.setHint("Name");
        add(txtUser, "w 60%");

        txtEmail = new MyTextField();
        // txtEmail.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        add(txtEmail, "w 60%");

        txtPass = new MyPasswordField();
        // txtPass.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        add(txtPass, "w 60%");

        cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        add(cmd, "w 40%, h 40");

    }

    public Button getBoton() {
        return cmd;
    }

    public String getUserName() {
        return txtUser.getText().trim();
    }

    public String getEmail() {
        return txtEmail.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

}
