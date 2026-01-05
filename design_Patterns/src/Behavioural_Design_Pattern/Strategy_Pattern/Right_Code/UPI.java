package Behavioural_Design_Pattern.Strategy_Pattern.Right_Code;


public class UPI implements PaymentStrategy {

    @Override
    public void Pay(double amount) {
        System.out.println("pay with UPI amount is "+amount);
    }
}
