package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Wrong_Code;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizza=new CheeseOlivePizza();
        System.out.println(pizza.getCost());
        System.out.println(pizza.getDescription());

    }
}
