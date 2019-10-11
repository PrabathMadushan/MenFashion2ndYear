package bank;

public abstract class Account {

    private final int accountNo;
    private double balance;
    private final AccountType type;
    private final AccountHolder holder;
    private boolean isActive;

    public Account(int accountNo, AccountType type, AccountHolder holder) {
        balance = 0d;
        this.accountNo = accountNo;
        this.type = type;
        this.holder = holder;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }
    
    protected final void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public AccountHolder getHolder() {
        return holder;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    

}
