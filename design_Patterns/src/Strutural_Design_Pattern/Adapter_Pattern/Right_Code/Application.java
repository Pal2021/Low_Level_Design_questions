package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;

public class Application {
    private DatabaseConnection databaseConnection;
    public Application(DatabaseConnection connection){
        this.databaseConnection=connection;
    }

    public void run(String url){
        databaseConnection.Connect(url);
        databaseConnection.DisConnect();
    }
}
