package Creational_Design_Pattern.Factory_Pattern.right_Code;


/* ========================================
   RIGHT WAY - With Factory Pattern
   ======================================== */

// Step 1: Create common interface
interface PaymentProcessor {
    void processPayment(double amount);
    void processRefund(double amount);
}

// Step 2: Implement the interface
class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card");
        System.out.println("Validating card number...");
        System.out.println("Charging credit card...");
    }

    @Override
    public void processRefund(double amount) {
        System.out.println("Refunding $" + amount + " to Credit Card");
    }
}

class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via PayPal");
        System.out.println("Redirecting to PayPal...");
        System.out.println("PayPal payment completed...");
    }

    @Override
    public void processRefund(double amount) {
        System.out.println("Refunding $" + amount + " to PayPal");
    }
}

class BankTransferProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Bank Transfer");
        System.out.println("Validating bank details...");
        System.out.println("Initiating transfer...");
    }

    @Override
    public void processRefund(double amount) {
        System.out.println("Refunding $" + amount + " to Bank");
    }
}

// Step 3: Create Factory (Enhanced for demonstration)
class PaymentProcessorFactory {
    public static PaymentProcessor createProcessor(String paymentType) {
        switch (paymentType.toLowerCase()) {
            case "creditcard":
                System.out.println("🏭 Factory: Creating Credit Card Processor");
                return new CreditCardProcessor();
            case "paypal":
                System.out.println("🏭 Factory: Creating PayPal Processor");
                return new PayPalProcessor();
            case "banktransfer":
                System.out.println("🏭 Factory: Creating Bank Transfer Processor");
                return new BankTransferProcessor();
            case "cryptocurrency":
                System.out.println("🏭 Factory: Creating Cryptocurrency Processor");
                return new CryptoCurrencyProcessor();
            default:
                System.out.println("❌ Factory: Unknown payment type requested: " + paymentType);
                throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }

    // Helper method for extensibility demonstration
    public static void addNewPaymentType(String type, java.util.function.Supplier<PaymentProcessor> supplier) {
        System.out.println("🔧 Factory: Would add support for " + type);
        // In real implementation, this might use a registry pattern
    }
}

// ✅ GOOD CLIENT CODE (Enhanced for demonstration)
class GoodECommerceSystem {

    public void processOrder(String paymentType, double amount) {
        System.out.println("\n🛒 Processing Order: $" + amount + " via " + paymentType.toUpperCase());
        try {
            // ✅ BENEFIT 1: Loose Coupling - Client only knows about interface
            PaymentProcessor processor = PaymentProcessorFactory.createProcessor(paymentType);
            processor.processPayment(amount);
            System.out.println("✅ Order processed successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Order failed: " + e.getMessage());
        }
    }

    public void processRefund(String paymentType, double amount) {
        System.out.println("\n💰 Processing Refund: $" + amount + " via " + paymentType.toUpperCase());
        try {
            // ✅ BENEFIT 2: No code duplication - Same creation logic
            PaymentProcessor processor = PaymentProcessorFactory.createProcessor(paymentType);
            processor.processRefund(amount);
            System.out.println("✅ Refund processed successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Refund failed: " + e.getMessage());
        }
        // ✅ BENEFIT 3: Easy to extend - Just add to factory
    }
}

// ✅ BENEFIT 4: Adding new payment method is easy!
class CryptoCurrencyProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Cryptocurrency");
    }

    @Override
    public void processRefund(double amount) {
        System.out.println("Refunding $" + amount + " to Crypto Wallet");
    }
}

// Just add one line to factory - client code remains unchanged!

/* ========================================
   DEMONSTRATION
   ======================================== */

public class ComparisonDemo {
    public static void main(String[] args) {
        System.out.println("\n=== GOOD WAY DEMO ===");
        GoodECommerceSystem goodSystem = new GoodECommerceSystem();
        goodSystem.processOrder("creditcard", 100.0);
        goodSystem.processRefund("paypal", 50.0);

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