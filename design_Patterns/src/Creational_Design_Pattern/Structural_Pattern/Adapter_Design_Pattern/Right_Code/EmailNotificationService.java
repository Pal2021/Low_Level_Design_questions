package Creational_Design_Pattern.Structural_Pattern.Adapter_Design_Pattern.Right_Code;

//Legacy Code: Email Notification Service
public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String to, String subject, String body) {
        System.out.println("Sending Email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: "+body);
    }
}
