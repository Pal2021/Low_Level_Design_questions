package Strutural_Design_Pattern.Decorator_Pattern.Right_Code;

// Abstract decorator - implements the same interface and wraps a component
abstract class CoffeeDecorator implements Coffee{

    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee=coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

}
