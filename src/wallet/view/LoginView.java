package wallet.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class LoginView extends javax.swing.JPanel {
    private javax.swing.JPanel login = new JPanel();
    private MyTextField txtEmail = new MyTextField();
    private MyPasswordField txtPass = new MyPasswordField();
    private Button cmd = new Button();
    private JLabel messageLabel = new JLabel();

    public LoginView(ActionListener eventLogin) {
        initLogin(eventLogin);
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);

        // txtEmail.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/resourses/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");

        // txtPass.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");

        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);

        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");

        messageLabel.setFont(new Font("sansserif", 0, 12));
        login.add(messageLabel);

    }

    public String getEmail() {
        return txtEmail.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }

    public void addLoginListener(ActionListener listener) {
        cmd.addActionListener(listener);
    }

}