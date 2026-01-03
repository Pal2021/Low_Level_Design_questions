
/*
L — Liskov Substitution Principle (LSP)
Definition (Simple)

A child class should replace its parent without breaking behavior.
If code works with parent, it should work with child also.
 */
// Bad design - breaks LSP
class BankAccount {
    void withdraw(double amount) {
        // Basic withdrawal logic
    }
}

class SavingsAccount extends BankAccount {
    @Override
    void withdraw(double amount) {
        if (amount > 1000) {
            System.out.println("Limit exceeded!"); // ❌ New restriction!
            return;
        }
        super.withdraw(amount);
    }
}

class FixedDeposit extends BankAccount {
    @Override
    void withdraw(double amount) {
        System.out.println("Cannot withdraw!"); // ❌ Completely different!
    }
}

// Client code breaks!
void processWithdrawal(BankAccount account) {
    account.withdraw(500); // Works for BankAccount, fails for FixedDeposit!
}
/*
Good code
 */
// Step 1: Define what accounts CAN do
interface Account {
    double getBalance();
    void deposit(double amount);
}

interface Withdrawable extends Account {
    void withdraw(double amount); // Only if account allows withdrawals
}

// Step 2: Create specific accounts
class CheckingAccount implements Withdrawable {
    private double balance;

    public void withdraw(double amount) {
        balance -= amount; // Always works
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount implements Withdrawable {
    private double balance;

    public void withdraw(double amount) {
        if (amount <= 1000) {
            balance -= amount; // Has limit but always works within it
        }
        // Still follows Withdrawable contract
    }

    // deposit() and getBalance() also implemented
}

class FixedDeposit implements Account { // No Withdrawable interface!
    private double balance;

    // Can't withdraw, so doesn't implement Withdrawable
    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

// Step 3: Client code that works perfectly
void processWithdrawal(Withdrawable account) {
    account.withdraw(500); // ✅ GUARANTEED to work!
}

void showBalance(Account account) {
    System.out.println(account.getBalance()); // ✅ Works for ALL accounts
}