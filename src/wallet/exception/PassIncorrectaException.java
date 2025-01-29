package wallet.exception;

public class PassIncorrectaException extends LogInException{
    public PassIncorrectaException(){
        super("Contraseña incorrecta");
    }
}
