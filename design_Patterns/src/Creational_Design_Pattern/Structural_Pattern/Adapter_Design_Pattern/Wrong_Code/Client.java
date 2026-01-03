package Creational_Design_Pattern.Structural_Pattern.Adapter_Design_Pattern.Wrong_Code;

public class Client{
    public static void main(String[] args) {
        NotificationService emailService=new EmailNotificationService();
        emailService.send("Customer@gmail.com","Hi customer","Hi my name is MR pal");


    }
}
