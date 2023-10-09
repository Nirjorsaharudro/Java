import java.math.BigDecimal;

public class Investment implements IAccount{
 
    private static int nextAccountNumber = 3000;
    private int accountNumber;
    private BigDecimal balance;

    public Investment(BigDecimal initialAmount) {
        this.accountNumber = nextAccountNumber++;
        this.balance = initialAmount;
    }

    @Override
    public void transfer(BigDecimal amount) {
        
        System.out.println("Transfer in Investment: "+amount);
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
    
}
