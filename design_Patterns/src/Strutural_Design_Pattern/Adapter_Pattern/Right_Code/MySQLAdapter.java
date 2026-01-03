package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;

import Strutural_Design_Pattern.Adapter_Pattern.Wrong_Code.MySQLConnection;

public class MySQLAdapter implements DatabaseConnection {
    public MySQLConnection mySQLConnection;

    public MySQLAdapter(){
        this.mySQLConnection=new MySQLConnection();
    }
    @Override
    public void Connect(String url) {
        mySQLConnection.ConnectMySQL(url);
    }

    @Override
    public void DisConnect() {
      mySQLConnection.CloseMySQL();
    }
}
