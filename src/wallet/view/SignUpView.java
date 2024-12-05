package wallet.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class SignUpView extends javax.swing.JPanel {
    private javax.swing.JPanel register = new JPanel();
    private MyTextField txtEmail = new MyTextField();
    private MyTextField txtUser = new MyTextField();
    private MyPasswordField txtPass = new MyPasswordField();
    private Button cmd = new Button();
    private JLabel messageLabel = new JLabel();

    public SignUpView(ActionListener eventRegister) {
        initRegister(eventRegister);
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);

        // txtUser.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 60%");

        // txtEmail.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");

        // txtPass.setPrefixIcon(new
        // ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");

        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");
    }

    public String getEmail() {
        return txtEmail.getText().trim();
    }

    public String getUserName() {
        return txtUser.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }

    public void addSignUpListener(ActionListener listener) {
        cmd.addActionListener(listener);
    }
}
