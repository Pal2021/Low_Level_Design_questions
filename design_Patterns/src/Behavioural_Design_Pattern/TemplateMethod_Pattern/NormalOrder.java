package Behavioural_Design_Pattern.TemplateMethod_Pattern;

public class NormalOrder extends OrderProcessor{

    @Override
    protected void calculatePrice() {
        System.out.println("Calculating price for normal order");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment for normal order");
    }
}
