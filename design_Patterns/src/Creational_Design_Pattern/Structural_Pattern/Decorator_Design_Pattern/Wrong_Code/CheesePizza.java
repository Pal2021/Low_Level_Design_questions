package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Wrong_Code;

public class CheesePizza extends BasicPizza{
    @Override
    public String getDescription() {
        return super.getDescription()+","+"Cheese";
    }

    @Override
    public Double getCost() {
        return super.getCost()+5.00;
    }
}
