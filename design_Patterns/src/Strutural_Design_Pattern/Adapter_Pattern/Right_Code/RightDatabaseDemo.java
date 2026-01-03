package Strutural_Design_Pattern.Adapter_Pattern.Right_Code;
/*

What is Adapter Pattern?
The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.
Real-World Analogy
Think of a power adapter when you travel to another country:

Your phone charger (US plug) doesn't fit foreign outlets (EU socket)
You use a power adapter to make them compatible
The adapter converts one interface to another


Problem It Solves
Scenario: You have two classes that need to work together, but their interfaces are incompatible.
Example Problem:
You have:
- An existing system that expects MediaPlayer interface
- A new advanced audio player (VLC, MP4) with different interface
- You want to use the new player without changing existing code
Without Adapter: You'd have to modify existing code (violates Open/Closed Principle)
With Adapter: Create an adapter that wraps the incompatible interface
 */
public class RightDatabaseDemo {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection=new MySQLAdapter();
        DatabaseConnection databaseConnection1=new PostgreSQLAdapter();

        Application application=new Application(databaseConnection);
        application.run("localhost:3306");

    }
}
