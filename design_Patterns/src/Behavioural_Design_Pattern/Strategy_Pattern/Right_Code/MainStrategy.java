package Behavioural_Design_Pattern.Strategy_Pattern.Right_Code;
/*
Strategy Pattern is a way to choose different ways of doing the same task at runtime.
Simple meaning:
Imagine you want to travel from home to office. You can choose different strategies:

🚗 Drive a car
🚌 Take a bus
🚴 Ride a bike

All strategies achieve the same goal (reaching office), but the method is different. You can decide which strategy to use based on your needs (traffic, weather, time).
In your code:

Goal: Pay money
Different strategies:

Pay with Debit Card
Pay with UPI


Context: PaymentContext decides which payment method to use

Benefits:

You can easily add new payment methods (like Credit Card, Cash) without changing existing code
You can switch payment methods at runtime
Each payment method has its own separate class, making code cleaner
 */
public class MainStrategy {
    public static void main(String[] args) {
        PaymentContext paymentStrategy=new PaymentContext(new DebitCard());
        paymentStrategy.executeTransaction(3000);
    }
}
