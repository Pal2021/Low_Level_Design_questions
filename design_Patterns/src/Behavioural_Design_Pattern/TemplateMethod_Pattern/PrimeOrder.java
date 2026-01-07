package Behavioural_Design_Pattern.TemplateMethod_Pattern;

class PrimeOrder extends OrderProcessor {

    @Override
    protected void calculatePrice() {
        System.out.println("Calculating price for prime order");
    }

    @Override
    protected void applyDiscount() {
        System.out.println("Applying prime discount");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing payment for prime order");
    }
}
