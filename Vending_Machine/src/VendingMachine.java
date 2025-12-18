// VendingMachine.java
import java.math.BigDecimal;

public class VendingMachine {
    private VendingMachineState state;
    private final Inventory inventory;
    private final PaymentHandler paymentHandler;

    public VendingMachine() {
        this.inventory = new Inventory();
        this.paymentHandler = new PaymentHandler();
        this.state = new IdleState(); // Initial State
        // Initialize inventory with sample items here
        inventory.addItem(new InventoryItem(new Item(101, "Coke", new BigDecimal("1.50")), 5, 1, 1));
    }

    // Delegate methods to the current state
    public void insertCoin(BigDecimal amount) { state.handleInsertCoin(this, amount); }
    public void selectItem(int itemId) { state.handleSelectItem(this, itemId); }
    // ... other delegating methods

    public void setState(VendingMachineState newState) { this.state = newState; }
    public Inventory getInventory() { return inventory; }
    public PaymentHandler getPaymentHandler() { return paymentHandler; }
    // ... getters

    // Example of a main runner method (can be in a separate Demo class)
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        System.out.println("Initial State: " + vm.state.getClass().getSimpleName());

        // User interaction example
        vm.insertCoin(new BigDecimal("1.00"));
        vm.insertCoin(new BigDecimal("0.50"));
        vm.selectItem(101); // Assuming SelectionState handles this and transitions to Dispensing
    }
}
