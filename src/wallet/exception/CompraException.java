package wallet.exception;

public class CompraException extends Exception {
    public CompraException (String msg){
        super(msg);
    }

    public CompraException (){
        super("Se produjo un error en la compra");
    }
}
