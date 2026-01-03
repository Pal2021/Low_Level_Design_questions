package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;


public class PostgresSQLConnection {
    public void connectPostgres(String url) {
        System.out.println("Connecting to PostgreSQL: " + url);
    }

    public void terminate() {
        System.out.println("Terminating PostgreSQL connection");
    }
}
