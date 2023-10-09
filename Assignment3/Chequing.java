import java.math.BigDecimal;

public class Chequing implements IAccount {
    private static int nextAccountNumber = 1000;
    private int accountNumber;
    private BigDecimal balance;

    public Chequing(BigDecimal initialAmount) {
        this.accountNumber = nextAccountNumber++;
        this.balance = initialAmount;
    }

    @Override
    public void transfer(BigDecimal amount) {
            System.out.println("Transfer in chequing: "+amount);
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

}
