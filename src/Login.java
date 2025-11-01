public class Login {
    private final AccountMap accountMap;

    public Login(AccountMap accountMap) {
        this.accountMap = accountMap;
    }

    public NewAccount authenticate(String accountNumber, String password) {
        NewAccount account = accountMap.getAccount(accountNumber);
        if (account == null) return null;

        String inputHash = HashUtil.generateSHA256(password);
        return inputHash.equals(account.getPasswordHash()) ? account : null;
    }
}
