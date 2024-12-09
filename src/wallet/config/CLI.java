package wallet.config;

public class CLI {
    public static void main(String[] args) {
        DataBaseConfig gestoBD = new DataBaseConfig();
        gestoBD.CreateDatabase();
        BilleteraVirtualManager gestor = new BilleteraVirtualManager();
        gestor.iniciar();
    }
}
