// IdleState.java
import java.math.BigDecimal;

public class IdleState implements VendingMachineState {
    @Override
    public void handleInsertCoin(VendingMachine machine, BigDecimal amount) {
        machine.getPaymentHandler().acceptMoney(amount);
        System.out.println("Accepted: $" + amount + ". Current balance: $" + machine.getPaymentHandler().getCurrentBalance());
        machine.setState(new SelectionState());
    }

    @Override
    public void handleSelectItem(VendingMachine machine, int itemId) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void handleDispenseItem(VendingMachine machine) {

    }

    @Override
    public void handleCancelRequest(VendingMachine machine) {

    }
    // ... other empty state methods for IdleState
}

