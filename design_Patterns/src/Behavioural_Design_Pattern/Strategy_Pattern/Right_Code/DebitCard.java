package Behavioural_Design_Pattern.Strategy_Pattern.Right_Code;

public class DebitCard implements PaymentStrategy{

    @Override
    public void Pay(double amount) {
        System.out.println("pay with Debit card amount is "+amount);
    }
}
