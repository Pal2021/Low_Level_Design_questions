package Creational_Design_Pattern.Structural_Pattern.Decorator_Design_Pattern.Right_Code;

public class BasicPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public Double getCost() {
        return 10.0;
    }
}
