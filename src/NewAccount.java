public class NewAccount {  // this class is used to create new account for the user ; value of key (in hashmap)
    private final String accountNumber;  // unique account number for each user ; its key but in case we need to print it we can access it
    private final String name;
    private final String passwordHash;
    private long balance;

    public NewAccount(String name, String  password, long balance) {
        if (name == null || name.isBlank())  throw new IllegalArgumentException("Name required");
        if ( password.length() < 4) throw new IllegalArgumentException("Password too weak");

        this.name = name;
        this.passwordHash = HashUtil.generateSHA256(password);
        this.balance = balance;
        this.accountNumber = "AC" + java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
           String getPasswordHash() { return passwordHash; }
    public long getBalance() { return balance; }
    public void setBalance(long balance) { this.balance = balance; }

    public void credit(long amount) {
        if (amount < 0) throw new IllegalArgumentException("Credit amount must be non-negative");
        this.balance += amount;
    }
    public void debit(long amount) {
        if (amount < 0) throw new IllegalArgumentException("Debit amount must be non-negative");
        if (amount > this.balance) throw new IllegalArgumentException("Insufficient balance");
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "NewAccount{name='" + name + "', balance=" + balance + "}";
    }
}
