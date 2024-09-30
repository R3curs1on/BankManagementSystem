

public class NewAccount {   // This class is used to create a new account ; this is actually a node of the linked list
        private String name;
        private String AccountNumber;
        private String Password;        //  in object pasword is stored in string format (hash)  ; but while making object of NewAccount we will pass the PIN  in int format
        private int Balance;
        NewAccount next;

        public NewAccount( String name , int Password , String AccountNumber , int Balance){     //constructor to Create a new account Node
            this.name=name;
            this.AccountNumber=AccountNumber;
            this.Password= (new HashUtil()).generateSHA256(String.valueOf(Password));                                 //Password;
            this.Balance=Balance;
            this.next=null;
        }

        public String displayAccountNumber(){ return AccountNumber; } // what is i removed public from here
        public String displayName() {         return name;          }     // what is i removed public from here
        public String displayPIN()     {         return Password;      }
        public int displayBalace()  {         return Balance;       }

        public void SetValue( int newValue){   Balance=newValue;     }
    }
