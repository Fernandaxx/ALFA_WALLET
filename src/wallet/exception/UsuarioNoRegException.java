package wallet.exception;

public class UsuarioNoRegException extends LogInException{
    public UsuarioNoRegException(){
        super("Usuario no registrado");
    }

}
