package wallet.view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PanelLoginAndRegister extends JPanel {

    private final LoginView loginView;
    private final SignUpView signUpView;

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        setLayout(new CardLayout());
        loginView = new LoginView(eventLogin);
        signUpView = new SignUpView(eventRegister);
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
