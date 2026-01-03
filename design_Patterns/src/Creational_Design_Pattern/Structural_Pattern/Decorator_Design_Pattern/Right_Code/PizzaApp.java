package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Right_Code;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizza=new BasicPizza();
        pizza=new CheeseDecorator(pizza);
        pizza=new OliveDecorator(pizza);
        System.out.println(pizza.getCost()+pizza.getDescription());
    }
}
