package Strutural_Design_Pattern.Adapter_Pattern.Wrong_Code;

public class WrongDatabaseDemo {
    public static void main(String[] args) {
        ConnectApplication app1 = new ConnectApplication("mysql");
        app1.ConnectDb("localhost:3306");


        ConnectApplication app2 = new ConnectApplication("postgres");
        app2.ConnectDb("localhost:5432");
    }
}
