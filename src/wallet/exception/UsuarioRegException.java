package wallet.exception;

public class UsuarioRegException extends SingUpException{
    public UsuarioRegException (String email){
        super("Usuario ya registrado con el email: "+email);
    }
}
