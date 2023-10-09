import java.math.BigDecimal;

public interface IAccount {
    void transfer(BigDecimal amount);
    int getAccountNumber();
    
}