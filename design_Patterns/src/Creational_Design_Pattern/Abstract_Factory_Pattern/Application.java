package Creational_Design_Pattern.Abstract_Factory_Pattern;

interface Button {
    void render();
}

interface Checkbox {
    void render();
}
// Window variants
class WindowsButton implements Button {
    public void render() {
        System.out.println("Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Windows Checkbox");
    }
}

//Mac Variants

class MacButton implements Button {
    public void render() {
        System.out.println("Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Mac Checkbox");
    }
}

// Abstract Factory(Interface)
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory of window factory
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory of Mac factory
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}


// Client Code
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        // Choose the factory based on OS
        GUIFactory factory;
        if (System.getProperty("os.name").contains("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}

/*

Abstract Factory vs. Factory Method
Factory Method -	Abstract Factory
Creates one product	- Creates families of related products
Uses inheritance (subclassing) -	Uses composition (object delegation)
Example: DocumentFactory (PDF, Word) -	Example: GUIFactory (Windows, Mac)
Advantages & Disadvantages
✔ Pros

Ensures compatibility between related objects.

Decouples client code from concrete implementations.

Follows Open/Closed Principle (easy to add new variants).

❌ Cons

Can be overkill if the system doesn’t need multiple families.

Adding new product types requires modifying the AbstractFactory interface.

Real-World Use Cases
UI Toolkits (Windows vs. macOS components)

Database Drivers (MySQL vs. PostgreSQL connections)

Game Development (Different enemy types for different levels)

Conclusion
The Abstract Factory Pattern is useful when you need to create entire families of objects while keeping them consistent and interchangeable. It’s a powerful extension of the Factory Method Pattern for more complex scenarios. 🚀

 */