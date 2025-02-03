package wallet.view.vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import net.miginfocom.swing.MigLayout;
import wallet.view.components.Button;
import wallet.view.components.Message;
import wallet.view.components.MyPasswordField;
import wallet.view.components.MyTextField;

public class LoginView extends JPanel {
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private Button cmd;
    private Button close;
    private MigLayout layout;

    public LoginView() {
        layout = new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push");
        setLayout(layout);

        close = new Button();
        close.setText("    X    ");
     //   close.setBorder( new LineBorder((new Color(158, 5, 158))));
        close.setBackground(new Color(158, 5, 158));
        close.setForeground(new Color(250, 250, 250));
        add(close,"pos 100%-30 0");
        

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

    public String getEmail() {
        return txtEmail.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    public Button getButton() {
        return cmd;
    }

    public Button getCloseButton(){
        return close;
    }

    public void showMessage(String message) {
        Message msg = new Message();
        msg.showMessage(message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!msg.isShow()) {
                    add(msg, "pos 0.5al -30", 0); // Insert to bg fist index 0
                    setVisible(true);
                    repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (msg.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(msg, "pos 0.5al " + (int) (f - 30));
                repaint();
                revalidate();
            }

            @Override
            public void end() {
                if (msg.isShow()) {
                    remove(msg);
                    repaint();
                    revalidate();
                } else {
                    msg.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000000000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
}
