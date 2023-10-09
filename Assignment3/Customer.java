import java.math.BigDecimal;

public class Customer {
    public static void main(String[] args) throws Exception {
        BankService bankService = new BankService();

        // Create accounts
        int chequingAccNumber = bankService.createNewAccount("Chequing", new BigDecimal(1000));
        int savingAccNumber = bankService.createNewAccount("Saving", new BigDecimal(2000));
        int investmentAccNumber = bankService.createNewAccount("Investment", new BigDecimal(5000));

        // Transfer money between accounts
        bankService.transferMoney(chequingAccNumber, savingAccNumber, new BigDecimal(500));
        bankService.transferMoney(investmentAccNumber, chequingAccNumber, new BigDecimal(1000));
        
    }
}
