package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Wrong_Code;

public class CheeseOlivePizza extends BasicPizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Olives";
    }

    @Override
    public Double getCost() {
        return super.getCost() + 0.50;
    }
}
