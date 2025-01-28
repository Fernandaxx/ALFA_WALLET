package wallet.exception;

public class CamposIncException extends SingUpException {
    public CamposIncException(){
        super("Verifique que todos los campos esten llenos");
    }
}
