package assignment;

public class BankTransaction implements Runnable {
    private BankAccount account;
    private boolean deposit;
    private int amount;

    public BankTransaction(BankAccount account, boolean deposit, int amount) {
        this.account = account;
        this.deposit = deposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
