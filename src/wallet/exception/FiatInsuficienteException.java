package wallet.exception;

public class FiatInsuficienteException extends CompraException{
    public FiatInsuficienteException(String fiat){
        super("Cantidad insuficiente de "+fiat);
    }
    public FiatInsuficienteException(){
        super("Cantidad insuficiente de Activo Fiat");
    }

}
