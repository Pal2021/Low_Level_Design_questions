package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Wrong_Code;

public class BasicPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Basic pizza";
    }

    @Override
    public Double getCost() {
        return 10.0;
    }
}
