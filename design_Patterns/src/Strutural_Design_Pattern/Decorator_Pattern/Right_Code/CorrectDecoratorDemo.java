package Strutural_Design_Pattern.Decorator_Pattern.Right_Code;

public class CorrectDecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== CORRECT DECORATOR PATTERN ===\n");

        // Simple coffee
        Coffee coffee1=new SimpleCoffee();
        System.out.println(coffee1.getDescription() + " - $" + coffee1.getCost());

        // Coffee with milk
        Coffee coffee2=new MilkDecorator(new SimpleCoffee());
        System.out.println(coffee2.getDescription() + " - $" + coffee2.getCost());

        // Coffee with milk and sugar
        Coffee coffee3 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffee3.getDescription() + " - $" + coffee3.getCost());


    }
}
