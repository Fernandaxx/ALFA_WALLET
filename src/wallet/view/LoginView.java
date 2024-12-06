package wallet.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.Message;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class LoginView extends JPanel {
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private Button cmd;
    private JButton cmdForget;

    public LoginView() {
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

        cmdForget = new JButton("Forgot your password?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cmdForget);

        cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
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

    public void showMessage(Message.MessageType type, String message) {
        JOptionPane.showMessageDialog(this, message, type.name(), type == Message.MessageType.SUCCESS
                ? JOptionPane.INFORMATION_MESSAGE
                : JOptionPane.ERROR_MESSAGE);
    }

    public void dispose() {
        setVisible(false);
    }

}
