package Behavioural_Design_Pattern.TemplateMethod_Pattern;

public class TemplateMethodDemo {
    public static void main(String[] args) {

        OrderProcessor order1 = new NormalOrder();
        order1.processOrder();

        System.out.println("------");

        OrderProcessor order2 = new PrimeOrder();
        order2.processOrder();
    }
}
/*
Template Method Pattern defines the skeleton of an algorithm in a parent class, but lets child classes override specific steps without changing the algorithm's structure.
Simple meaning:
Think of it like a recipe template:

🍳 Recipe steps are fixed: Prepare → Cook → Serve
🎨 But each dish is different: Pizza vs Pasta vs Salad
Each follows the same steps, but does them differently
 */