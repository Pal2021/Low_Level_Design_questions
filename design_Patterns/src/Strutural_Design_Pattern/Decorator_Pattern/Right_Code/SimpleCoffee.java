package Strutural_Design_Pattern.Decorator_Pattern.Right_Code;

// Concrete component - the base object we want to decorate
public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
