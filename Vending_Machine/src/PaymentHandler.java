import java.math.BigDecimal;

public class PaymentHandler {

    private BigDecimal currentBalance=BigDecimal.ZERO;
    public void acceptMoney(BigDecimal amount) {
        currentBalance = currentBalance.add(amount);
    }
    public boolean processPayment(BigDecimal amount){
        if (currentBalance.compareTo(amount) >= 0) {
            currentBalance = currentBalance.subtract(amount);
            return true;
        }
        return false;
    }

    public BigDecimal returnChange() {
        BigDecimal change = currentBalance;
        currentBalance = BigDecimal.ZERO;
        return change;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
}
