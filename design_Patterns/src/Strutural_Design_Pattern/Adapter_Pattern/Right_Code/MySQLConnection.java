package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;

public class MySQLConnection {
    public void connectMySQL(String url) {
        System.out.println("Connecting to MySQL: " + url);
    }
    public void close() {
        System.out.println("Closing MySQL connection");
    }
}
