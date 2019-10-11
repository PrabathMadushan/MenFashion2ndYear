
package bank;


public class FixedDepositAccount extends Account{
    
    public FixedDepositAccount(int accountNo, AccountType type, AccountHolder holder,double ammount) {
        super(accountNo, type, holder);
        setBalance(ammount);
    }
    
    public void closeAndWithdraw(){
        setIsActive(false);
        setBalance(0);
    }
    
    
}
