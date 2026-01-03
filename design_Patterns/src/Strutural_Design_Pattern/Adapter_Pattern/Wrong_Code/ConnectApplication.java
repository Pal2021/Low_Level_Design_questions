package Strutural_Design_Pattern.Adapter_Pattern.Wrong_Code;

public class ConnectApplication {
    private MySQLConnection mySQLConnection;
    private PostgreSQLConnection postgreSQLConnection;
    private String dbType;
    public ConnectApplication(String dbType){
        this.dbType=dbType;
        if(dbType.equals("mySQL")){
            mySQLConnection=new MySQLConnection();
        }else{
            postgreSQLConnection=new PostgreSQLConnection();
        }

    }
    void ConnectDb( String url){
        if(dbType.equals("mySQL")){
            mySQLConnection.ConnectMySQL(url);
        }else{
            postgreSQLConnection.connectPostgres(url);
        }
    }
}
