
public class Login {
        private  LinkedList accounts;  //linked list to store the accounts;
        public  Login(LinkedList accounts){  //constructor to initialize the linked list
            this.accounts=accounts;
        }

        public  boolean AccountExists(String AccountNumber ,int password){  //method to check if the account exists
            NewAccount found=accounts.search(AccountNumber);  //search the account
            return found!=null && found.displayPIN().equals( (new HashUtil()).generateSHA256(String.valueOf(password)) );  //return true if the account exists with account number in object found and whether the password hash is equal to given password hash ; else return false
        }

        public  NewAccount Search(String AccountNumber){  //method to search an account   in main class i need to change the datatype of the return type Account to NewAccount
            return accounts.search(AccountNumber);  //return the account if found ; else return null
        }

        public int getBalance(NewAccount found){  //method to get the balance of an account
            return found.displayBalace();  //return the balance of the account
        }

        public void updateBalenceDebit(NewAccount Found , int amt){  //method to update the balance of an account after debit
            int finalvalue=Found.displayBalace()-amt;  //calculate the new balance
            Found.SetValue( finalvalue);  //update the balance
        }

        public void updateBalenceCredit(NewAccount Found,int amt){  //method to update the balance of an account after credit
            int finalvalue=Found.displayBalace()+amt;  //calculate the new balance
            Found.SetValue( finalvalue);  //update the balance
        }

        public void Delete(NewAccount Found){  //method to delete an account
            accounts.delete(Found.displayAccountNumber());  //delete the account
        }
    }


