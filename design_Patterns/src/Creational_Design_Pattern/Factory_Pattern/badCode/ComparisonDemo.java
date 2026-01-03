package Creational_Design_Pattern.Factory_Pattern.badCode;/* ========================================
   WRONG WAY - Without Factory Pattern
   ======================================== */

// Payment classes (these are fine)
class CreditCard {
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card");
        // Credit card specific logic
        System.out.println("Validating card number...");
        System.out.println("Charging credit card...");
    }
}

class PayPal {
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via PayPal");
        // PayPal specific logic
        System.out.println("Redirecting to PayPal...");
        System.out.println("PayPal payment completed...");
    }
}

class BankTransfer {
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Bank Transfer");
        // Bank transfer specific logic
        System.out.println("Validating bank details...");
        System.out.println("Initiating transfer...");
    }
}

// 🔴 BAD CLIENT CODE - This is the problematic part! (Enhanced for demonstration)
class BadECommerceSystem {

    public void processOrder(String paymentType, double amount) {
        System.out.println("\n🛒 Processing Order: $" + amount + " via " + paymentType.toUpperCase() + " (BAD WAY)");

        // 🚨 PROBLEM 1: Tight Coupling - Client knows about all concrete classes
        if (paymentType.equals("creditcard")) {
            System.out.println("🚨 BAD: Client code directly creating CreditCard object");
            CreditCard payment = new CreditCard();
            payment.processPayment(amount);
        } else if (paymentType.equals("paypal")) {
            System.out.println("🚨 BAD: Client code directly creating PayPal object");
            PayPal payment = new PayPal();
            payment.processPayment(amount);
        } else if (paymentType.equals("banktransfer")) {
            System.out.println("🚨 BAD: Client code directly creating BankTransfer object");
            BankTransfer payment = new BankTransfer();
            payment.processPayment(amount);
        } else {
            // 🚨 PROBLEM 2: Error handling scattered everywhere
            System.out.println("❌ Invalid payment type: " + paymentType);
            System.out.println("🚨 BAD: Error handling mixed with business logic");
        }

        // 🚨 PROBLEM 3: What if we need to add new payment method?
        // We have to modify this method every time!
        System.out.println("🚨 PROBLEM: Adding cryptocurrency would require modifying this method");
    }

    // 🚨 PROBLEM 4: Code duplication - Similar logic repeated
    public void processRefund(String paymentType, double amount) {
        System.out.println("\n💰 Processing Refund: $" + amount + " via " + paymentType.toUpperCase() + " (BAD WAY)");

        if (paymentType.equals("creditcard")) {
            System.out.println("🚨 BAD: Duplicated creation logic");
            CreditCard payment = new CreditCard();
            // Different refund logic but same creation pattern
            System.out.println("Refunding $" + amount + " to Credit Card");
        } else if (paymentType.equals("paypal")) {
            System.out.println("🚨 BAD: More duplicated creation logic");
            PayPal payment = new PayPal();
            System.out.println("Refunding $" + amount + " to PayPal");
        } else if (paymentType.equals("banktransfer")) {
            System.out.println("🚨 BAD: Even more duplicated creation logic");
            BankTransfer payment = new BankTransfer();
            System.out.println("Refunding $" + amount + " to Bank");
        }
        // This will grow and become unmaintainable!
        System.out.println("🚨 PROBLEM: Same if-else logic repeated, prone to copy-paste errors");
    }
}


// Just add one line to factory - client code remains unchanged!

/* ========================================
   DEMONSTRATION
   ======================================== */

public class ComparisonDemo {
    public static void main(String[] args) {
        System.out.println("=== BAD WAY DEMO ===");
        BadECommerceSystem badSystem = new BadECommerceSystem();
        badSystem.processOrder("creditcard", 100.0);
        badSystem.processRefund("paypal", 50.0);

        // Adding cryptocurrency is easy with good design!
        // (You'd add the case to factory first)
        System.out.println("\n=== EXTENDING WITH NEW PAYMENT METHOD ===");
        // This would work after adding crypto case to factory
        // goodSystem.processOrder("cryptocurrency", 75.0);
    }
}

/* ========================================
   PROBLEMS IN WRONG CODE:
   ========================================
   
   🚨 TIGHT COUPLING
   - Client code directly creates concrete objects
   - Client must know about all payment classes
   - Hard to test (can't mock easily)
   
   🚨 VIOLATES OPEN/CLOSED PRINCIPLE
   - Adding new payment method requires modifying existing code
   - Changes in one place affect multiple places
   
   🚨 CODE DUPLICATION
   - Same if-else logic repeated in multiple methods
   - Same object creation pattern everywhere
   
   🚨 POOR ERROR HANDLING
   - Error handling scattered throughout
   - Inconsistent error messages
   
   🚨 HARD TO MAINTAIN
   - Code becomes complex as new payment methods are added
   - Difficult to unit test individual components
   
   🚨 POOR SCALABILITY
   - Each new payment method requires touching existing code
   - Risk of breaking existing functionality
   
   ✅ BENEFITS OF FACTORY PATTERN:
   - Loose coupling between client and concrete classes
   - Easy to extend with new payment methods
   - Centralized creation logic
   - Better error handling
   - Easier to test and maintain
   - Follows SOLID principles
*/