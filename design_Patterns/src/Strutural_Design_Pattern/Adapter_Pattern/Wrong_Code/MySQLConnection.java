package Strutural_Design_Pattern.Adapter_Pattern.Wrong_Code;

public class MySQLConnection {
    public void ConnectMySQL(String url){
        System.out.println("my sql is connection with url"+url);
    }
    public void CloseMySQL(){
        System.out.println("my sql is disconnection");
    }
}

