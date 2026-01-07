package Behavioural_Design_Pattern.Observer_Pattern.Right_Code;

public class Subscriber implements Observer {
    private String subscriberName;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("📧 " + subscriberName + " received notification: New video '" + videoTitle + "' is uploaded!");
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}