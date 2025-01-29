package wallet.exception;

public class LogInException extends Exception{
    public LogInException(String msg){
        super(msg);
    }
    public LogInException(){
        super("Se produjo un error en el inicio de sesion");
    }

}