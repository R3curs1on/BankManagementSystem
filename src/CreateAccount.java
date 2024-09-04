
    public class CreateAccount {
        public static int newAccountToken = 0;

        public static  String GenerateAccountNumber(){
            newAccountToken++;
            return "AC"+newAccountToken;
        }

        public static NewAccount createAccount(String name , int Password ,int Balance){
            return new NewAccount(name,Password,GenerateAccountNumber(),Balance);
        }


    }


