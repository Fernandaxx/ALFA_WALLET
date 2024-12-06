package wallet.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class LoginView extends JPanel {

    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private ModelLogin dataLogin;

    public LoginView(ActionListener eventLogin) {
        setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        add(label);

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

        JButton cmdForget = new JButton("Forgot your password?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cmdForget);

        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        add(cmd, "w 40%, h 40");

        cmd.addActionListener(eventLogin);
        cmd.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            String password = String.valueOf(txtPass.getPassword());
            dataLogin = new ModelLogin(email, password);
        });
    }

    public ModelLogin getDataLogin() {
        return dataLogin;
    }
}
