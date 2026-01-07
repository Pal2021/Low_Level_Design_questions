package Behavioural_Design_Pattern.TemplateMethod_Pattern;

class InternationalOrder extends OrderProcessor {

    @Override
    protected void calculatePrice() {
        System.out.println("Calculating price with customs duty");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing international payment");
    }
}
