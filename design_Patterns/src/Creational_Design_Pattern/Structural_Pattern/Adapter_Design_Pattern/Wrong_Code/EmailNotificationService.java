package Creational_Design_Pattern.Structural_Pattern.Adapter_Design_Pattern.Wrong_Code;

public class EmailNotificationService implements NotificationService{
    public  void send(String to,String subject,String body){
        System.out.println("Sending to :"+to);
        System.out.println("Subject: "+subject);
        System.out.println("Body: "+body);
    }
}
