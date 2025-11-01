//public final class CreateAccount {
//    private static long newAccountToken = System.nanoTime();
//    private CreateAccount() {}
//
//    public static String generateAccountNumber(String name) {
//        newAccountToken++;
//        return "AC" + uniqueAccountNumberHash(newAccountToken, name);
//    }
//
//    private static String uniqueAccountNumberHash(long n, String name) {
//        HashUtil hasher = new HashUtil();
//        String uniqueString = name + n;
//        return hasher.generateSHA256(uniqueString).substring(0, 12);
//    }
//
//}
