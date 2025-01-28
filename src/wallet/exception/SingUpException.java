package wallet.exception;

public abstract class SingUpException extends Exception {
    public SingUpException(String msg) {
        super(msg);  
    }

    public SingUpException(){
        super("Se profujo un error en el registro");
    }
}
