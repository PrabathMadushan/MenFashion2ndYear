package bank;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNo, AccountType type, AccountHolder holder) {
        super(accountNo, type, holder);
    }

    public double checkBalance() {
        return getBalance();
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
        }
    }

}
