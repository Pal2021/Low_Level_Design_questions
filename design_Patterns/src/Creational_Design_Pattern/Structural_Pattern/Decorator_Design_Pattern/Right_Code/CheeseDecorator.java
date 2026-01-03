package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Right_Code;

public class CheeseDecorator extends PizzaDecorator{


    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    public String getDescription(){
        return decoratedPizza.getDescription() + ", Cheese";
    }
    public Double getCost(){
        return decoratedPizza.getCost() + 1.00;
    }
}
