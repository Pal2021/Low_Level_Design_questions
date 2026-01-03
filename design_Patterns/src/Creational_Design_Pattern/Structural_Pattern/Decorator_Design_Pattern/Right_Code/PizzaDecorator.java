package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Right_Code;

abstract class PizzaDecorator extends BasicPizza{
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza){
        this.decoratedPizza=pizza;
    }
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public Double getCost() {
        return decoratedPizza.getCost();
    }
}
