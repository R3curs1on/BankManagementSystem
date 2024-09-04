import java.util.*;


// This is the main class of the project
    public class Main {

        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            // Name Account Pin Balence Credit Debit

            LinkedList accounts = new LinkedList();
            Login Login = new Login(accounts);

            while (true) {
                System.out.println("enter a choilce :\n(1).Create Account \n(2).Login \n(3).Exit");       int choice= sc.nextInt();
                if (choice==3){ break;}            // Exit

                else if (choice==1) {              // Create Account
                    System.out.println("enter name : ");                      String name=sc.next();
                    System.out.println("enter password : ");                  int password=sc.nextInt();
                    System.out.println("enter balence (Optional): ");         int balence=0 ; String amt =sc.next(); if (!amt.isEmpty()) balence+=Integer.parseInt(amt);
                    System.out.println("Successfully created Account ");      String AccountNumber=CreateAccount.GenerateAccountNumber();     //this function is not implemented yet ; it generates a unique account number
                    System.out.println("Account Number : "+AccountNumber);

                    NewAccount newAccount = new NewAccount(name,password,AccountNumber,balence);  // this line is commented because the class NewAccount is not implemented yet
                    accounts.add(newAccount);  // this line is commented because the class LinkedList is not implemented yet
                }

                else if (choice==2) {             // Login
                    System.out.println("enter Account Number : ");      String AccountNumber=sc.next();
                    System.out.println("enter password : ");            int password=sc.nextInt();

                    if (Login.AccountExists(AccountNumber,password)) {                // this function is not implemented yet ; it checks if account exist or not
                        NewAccount Found = Login.Search(AccountNumber);                  // this function is not implemented yet ; it returns the account object to avoud searching again

                        System.out.println("Account exist ");

                        System.out.println("Welcome to your account "+Found.displayName());    //this Attribute is not implemented yet ; it returns name of account holder

                        System.out.println("enter a choilce :\n(0).Delete Account \n(1).Check Balence \n(2).Credit \n(3).Debit \n(4).Exit");
                        int choice2=sc.nextInt();

                        while (choice2!=4 || choice2!=0){
                            if (choice2==4) { break; }
                            else if (choice2==0) { System.out.println("Account Deleted "); Login.Delete(Found) ;        }                                            // this function is not implemented yet ; it deletes the account
                            else if (choice2==1) { System.out.println("Balence is : "+Login.getBalance(Found)); }       // this function is not implemented yet ; it returns the balence of account
                            else if (choice2==2) { System.out.println("enter amount to credit : "); int credit=sc.nextInt(); Login.updateBalenceCredit(Found,credit); }    // this function is not implemented yet ; it updates credit balence of account

                            else if (choice2==3) { System.out.println("enter amount to debit : "); int debit=sc.nextInt();  Login.updateBalenceDebit(Found,debit); }       //this function is not implemented yet ; it updates debit balence of account

                            else { System.out.println("Invalid choice Try again"); }
                            System.out.println("enter a choilce :\n(0).Delete Account \n(1).Check Balence \n(2).Credit \n(3).Debit \n(4).Exit");
                            choice2=sc.nextInt();

                        }
                    }
                    else { System.out.println("Account does not exist Try Again"); }
                }
                else {                            // Invalid choice case
                    System.out.println("Invalid choice Try again ");
                }

            }

        }
    }


