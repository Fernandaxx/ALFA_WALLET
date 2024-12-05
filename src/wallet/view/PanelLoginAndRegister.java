package wallet.view;

import java.awt.CardLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    private LoginView login;
    private SignUpView register;

    public PanelLoginAndRegister(LoginView login, SignUpView register) {
        this.login = login;
        this.register = register;

        initComponents();
    }

    private void initComponents() {
        setLayout(new CardLayout());
        add(login, "login");
        add(register, "register");
    }

    public void showRegister(boolean show) {
        CardLayout layout = (CardLayout) getLayout();
        if (show) {
            layout.show(this, "register");
        } else {
            layout.show(this, "login");
        }
    }
}