// This file contains the class which is used to create new account for the user
    public class CreateAccount {
        public static int newAccountToken = 0;

        public static  String GenerateAccountNumber(String name){ // takes "name"+"newAccountToken"  and returns a unique account number
            newAccountToken++;  // unique for each time and each user
            return "AC"+uniqueAccountNumberHash(newAccountToken,name);  // acc format AC+someUniqueString
        }

        public static String uniqueAccountNumberHash(int n,String Name){  // this function gives sha256 hash of given number (newAccountToken)
            HashUtil hasher = new HashUtil();               // object which contains functn to generate hash
            String uniqueString = Name+String.valueOf(n);        // so "Name"+"newAccountToken" is unique for each user ; we will take hash of it as unique acc number
            return hasher.generateSHA256(uniqueString);
        }

        public static NewAccount createAccount(String name , int Password ,int Balance){  // this function is used to create a new account Node
            return new NewAccount(name,Password,GenerateAccountNumber(name),Balance);
         }

    }