import java.util.HashMap;
public class AccountMap { // this is  actuall hashmap which will be used for storing accounts
    private HashMap<String, NewAccount > accountMap;
    public AccountMap() {
        this.accountMap = new HashMap<>();
    }

    public void addAccount(NewAccount account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public NewAccount getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }


    public void removeAccount(String accountNumber) {
        accountMap.remove(accountNumber);
    }

    public void displayAccounts() {
        for (NewAccount account : accountMap.values()) {
            System.out.println(account);
        }
    }
    public void clearAccounts() {
        accountMap.clear();
    }

    public int getSize() {
        return accountMap.size();
    }

    public boolean containsAccount(String accountNumber) {
        return accountMap.containsKey(accountNumber);
    }

    public boolean updateAccountBalance(String accountNumber, int newBalance) {
        NewAccount account = accountMap.get(accountNumber);
        if (account != null) {
            account.setBalance(newBalance);
            return true;
        }
        System.out.println("Account number not found: " + accountNumber);
        return false;
    }


    public void loadAccountsFromPersistentStorage() {
        // Implement persistent storage logic here (e.g., load from a file or database)
    }

    public void saveAccountsPersistently() {
        // Implement persistent storage logic here (e.g., save to a file or database)
    }

    public HashMap<String, NewAccount> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(HashMap<String, NewAccount> accountMap) {
        this.accountMap = accountMap;
    }

    public void logAccounts() {
        // Implement logging logic here (e.g., log to a file or console)
        // like created accounts , deleted accounts , updated accounts ;
        // it shoulld be able to log the methods called on the hashmap / or something like that

    }


}
