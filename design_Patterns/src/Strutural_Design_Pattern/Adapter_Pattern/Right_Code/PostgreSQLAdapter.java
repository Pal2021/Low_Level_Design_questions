package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;

public class PostgreSQLAdapter implements DatabaseConnection {
    public PostgresSQLConnection postgresSQLConnection;

    public PostgreSQLAdapter(){
        this.postgresSQLConnection=new PostgresSQLConnection();
    }
    @Override
    public void Connect(String url) {
        postgresSQLConnection.connectPostgres(url);
    }

    @Override
    public void DisConnect() {
       postgresSQLConnection.terminate();
    }
}
