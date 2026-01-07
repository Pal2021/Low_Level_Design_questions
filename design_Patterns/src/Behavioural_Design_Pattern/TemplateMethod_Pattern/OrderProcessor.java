package Behavioural_Design_Pattern.TemplateMethod_Pattern;

public abstract class OrderProcessor {

    // Template Method (algorithm skeleton)
    public final void processOrder(){
        validateOrder();
        calculatePrice();
        applyDiscount();   // hook
        processPayment();
        generateInvoice();
    }

    protected void validateOrder() {
        System.out.println("Validating order");
    }

    protected abstract void calculatePrice();

    // Hook method (optional)
    protected void applyDiscount() {
        // default: no discount
    }

    protected abstract void processPayment();

    protected void generateInvoice() {
        System.out.println("Generating invoice");
    }
}
