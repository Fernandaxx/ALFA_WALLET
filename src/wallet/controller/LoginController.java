package wallet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallet.exception.CamposIncException;
import wallet.exception.PassIncorrectaException;
import wallet.exception.UsuarioNoRegException;
import wallet.model.dto.LoginModel;
import wallet.model.entity.Usuario;
import wallet.view.vistas.CentralFrame;
import wallet.view.vistas.InicialFrame;
import wallet.view.vistas.LoginView;

public class LoginController {
    private LoginView view;
    private LoginModel model;
    private InicialFrame mainFrame;

    public LoginController(LoginView view, LoginModel model, InicialFrame mainFrame) {
        this.view = view;
        this.model = model;
        this.mainFrame = mainFrame;

        view.getButton().addActionListener(new LoginAction());

    }

    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            String password = view.getPassword();
            try{
            Login(email,password);
             }catch (PassIncorrectaException ex){
            view.showMessage(ex.getMessage());
            }catch (UsuarioNoRegException ex){
                view.showMessage(ex.getMessage());
            }catch (CamposIncException ex){
                view.showMessage(ex.getMessage());
            }
        }
    }

    private void Login (String email, String password) throws PassIncorrectaException,UsuarioNoRegException,CamposIncException{  
            if (!(email.isEmpty() || password.isEmpty())) {
                Usuario usuario = model.usuarioRegistrado(email);
                if (usuario != null) {
                    if (model.correctPassword(email, password)) {
                        view.showMessage("Bienvenido");
                        mainFrame.dispose();
                        CentralFrame.main(model.obtenerIdUSer(email));

                    } else {
                        throw new PassIncorrectaException();
                    }
                } else {
                    throw new UsuarioNoRegException();
                }
            } else {
                throw new CamposIncException();
            }
        }
    }
