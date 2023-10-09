import java.math.BigDecimal;
import java.util.Hashtable;

public class BankService {
    private Hashtable<Integer, IAccount> bankAccounts;

    public BankService() {
        this.bankAccounts = new Hashtable<>();
    }

    public int createNewAccount(String type, BigDecimal initAmount) {
        IAccount newAccount = null;
        switch (type) {
            case "Chequing":
                newAccount = new Chequing(initAmount);
                break;
            case "Saving":
                newAccount = new Saving(initAmount);
                break;
            case "Investment":
                newAccount = new Investment(initAmount);
                break;
            default:
                System.out.println("Invalid Account type");
        }

        if (newAccount != null) {
            this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
            return newAccount.getAccountNumber();
        }
        return -1;
    }

    public void transferMoney(int to, int from, BigDecimal amount) {
        IAccount toAccount = this.bankAccounts.get(to);
        IAccount fromAccount = this.bankAccounts.get(from);

        if (toAccount != null && fromAccount != null) {
            fromAccount.transfer(amount);
            // Adjust balance for both accounts
        } else {
            System.out.println("Invalid account numbers.");
        }
    }
}
