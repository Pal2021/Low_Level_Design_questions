package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Right_Code;

public class OliveDecorator extends PizzaDecorator {


    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }
    public String getDescription(){
        return super.getDescription() + ", Olive";
    }
    public Double getCost(){
        return decoratedPizza.getCost() + 0.50;
    }
}
