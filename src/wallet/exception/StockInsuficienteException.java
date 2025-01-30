package wallet.exception;

public class StockInsuficienteException extends CompraException{
    public StockInsuficienteException(String cripto){
        super("Stock insuficiente de "+cripto);
    }

    public StockInsuficienteException(){
        super("Stock insuficiente de criptomoneda");
    }
}
