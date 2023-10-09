import java.math.BigDecimal;

public class Saving implements IAccount {
  
    private static int nextAccountNumber = 2000;
    private int accountNumber;
    private BigDecimal balance;

    public Saving(BigDecimal initialAmount) {
        this.accountNumber = nextAccountNumber++;
        this.balance = initialAmount;
    }

    @Override
    public void transfer(BigDecimal amount) {
       System.out.println("Transfer in Saving: "+amount);
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
    
}
