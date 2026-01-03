package Strutural_Design_Pattern.Decorator_Pattern.Right_Code;
// Concrete decorators - add specific functionality
public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription(){
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

}
