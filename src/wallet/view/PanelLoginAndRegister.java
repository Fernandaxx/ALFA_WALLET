package wallet.view;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class PanelLoginAndRegister extends JPanel {

    private LoginView loginView;
    private SignUpView signUpView;

    public PanelLoginAndRegister(LoginView loginView, SignUpView signUpView) {
        setLayout(new CardLayout());
        this.loginView = loginView;
        this.signUpView = signUpView;
        add(loginView, "login");
        add(signUpView, "register");
        showRegister(true);
    }

    public void showRegister(boolean show) {
        CardLayout layout = (CardLayout) getLayout();
        if (show) {
            layout.show(this, "register");
        } else {
            layout.show(this, "login");
        }
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public SignUpView getSignUpView() {
        return signUpView;
    }
}
