package Behavioural_Design_Pattern.Strategy_Pattern.Right_Code;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    void executeTransaction(double amount){
        paymentStrategy.Pay(6576);
    }

}
