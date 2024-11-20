package wallet;

import wallet.config.DataBaseConfig;

public class Main {

    public static void main(String[] args) {
        DataBaseConfig dataBase = new DataBaseConfig();
        dataBase.CreateDatabase();
    }
}
