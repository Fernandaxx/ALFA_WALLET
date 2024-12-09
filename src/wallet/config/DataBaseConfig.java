package wallet.config;

import java.sql.*;

public class DataBaseConfig {

    /**
     * Este método se encarga de la creación de las tablas.
     *
     * @param connection objeto conexion a la base de datos SQLite
     * @throws SQLException
     */
    private static void creaciónDeTablasEnBD(Connection connection) throws SQLException {
        Statement stmt;
        stmt = connection.createStatement();
        String sql = "CREATE TABLE  IF NOT EXISTS PERSONA "
                + "("
                + " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + " NOMBRES       VARCHAR(50)    NOT NULL, "
                + " APELLIDOS       VARCHAR(50)    NOT NULL "
                + ")";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE  IF NOT EXISTS USUARIO " + "(" + " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + " ID_PERSONA       INTEGER   NOT NULL, "
                + " EMAIL       VARCHAR(50)    NOT NULL, "
                + " PASSWORD       VARCHAR(50)    NOT NULL, "
                + " ACEPTA_TERMINOS       BOOLEAN    NOT NULL, "
                + " FOREIGN KEY(ID_PERSONA) REFERENCES PERSONA(ID)"
                + ")";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE  IF NOT EXISTS MONEDA "
                + "("
                + " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + " TIPO       VARCHAR(1)    NOT NULL, "
                + " NOMBRE       VARCHAR(50)    NOT NULL, "
                + " NOMENCLATURA VARCHAR(10)  NOT NULL, "
                + " VALOR_DOLAR	REAL     NOT NULL, "
                + " VOLATILIDAD	REAL     NULL, "
                + " STOCK	REAL     NULL, "
                + " NOMBRE_ICONO       VARCHAR(50)    NOT NULL "
                + ")";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE  IF NOT EXISTS ACTIVO_CRIPTO"
                + "("
                + " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + " ID_USUARIO INTEGER    NOT NULL, "
                + " ID_MONEDA INTEGER    NOT NULL, "
                + " CANTIDAD	REAL    NOT NULL, "
                + " FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID),"
                + " FOREIGN KEY(ID_MONEDA) REFERENCES MONEDA(ID) "
                + ")";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE  IF NOT EXISTS ACTIVO_FIAT"
                + "("
                + " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + " ID_USUARIO INTEGER    NOT NULL, "
                + " ID_MONEDA INTEGER    NOT NULL, "
                + " CANTIDAD	REAL    NOT NULL, "
                + " FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID),"
                + " FOREIGN KEY(ID_MONEDA) REFERENCES MONEDA(ID)"
                + ")";
        stmt.executeUpdate(sql);
        sql = "CREATE TABLE  IF NOT EXISTS TRANSACCION"
                + "("
                + " ID     INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + " RESUMEN VARCHAR(1000)   NOT NULL, "
                + " FECHA_HORA		DATETIME  NOT NULL, "
                + " ID_USUARIO INTEGER    NOT NULL, "
                + " FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID)"
                + ")";
        stmt.executeUpdate(sql);

        stmt.close();
    }

    public void CreateDatabase() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            creaciónDeTablasEnBD(c);
            // borrarMoneda();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void borrarMoneda() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
            String sql = "DELETE FROM ACTIVO_CRIPTO ";
            PreparedStatement pstmt = c.prepareStatement(sql);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new RuntimeException();
            }
            pstmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Operación realizada con éxito");
    }

    public void borrarTabla(String nombreTabla) {
        String sql = "DROP TABLE IF EXISTS " + nombreTabla;

        try (Connection c = DriverManager.getConnection("jdbc:sqlite:ALFA_WALLET.db");
                Statement stmt = c.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla " + nombreTabla + " eliminada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar la tabla: " + e.getMessage());
        }
    }

}
