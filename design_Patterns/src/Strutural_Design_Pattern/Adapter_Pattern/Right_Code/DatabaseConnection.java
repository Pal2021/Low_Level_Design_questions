package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;

public interface DatabaseConnection {
    void Connect(String url);
    void DisConnect();
}
