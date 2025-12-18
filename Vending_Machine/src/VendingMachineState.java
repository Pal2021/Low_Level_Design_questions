import java.math.BigDecimal;

public interface VendingMachineState {
    void handleInsertCoin(VendingMachine machine, BigDecimal amount);
    void handleSelectItem(VendingMachine machine, int itemId);
    void handleDispenseItem(VendingMachine machine);
    void handleCancelRequest(VendingMachine machine);
}
