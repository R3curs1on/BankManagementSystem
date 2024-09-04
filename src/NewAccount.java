
    public class NewAccount {   // This class is used to create a new account ; this is actually a node of the linked list
        private String name;
        private String AccountNumber;
        private int Password;
        private int Balance;
        NewAccount next;

        public NewAccount( String name , int Password , String AccountNumber , int Balance){     //constructor to Create a new account Node
            this.name=name;
            this.AccountNumber=AccountNumber;
            this.Password=Password;
            this.Balance=Balance;
            this.next=null;
        }

        public String displayAccountNumber(){ return AccountNumber; } // what is i removed public from here
        public String displayName() {         return name;          }     // what is i removed public from here
        public int displayPIN()     {         return Password;      }
        public int displayBalace()  {         return Balance;       }

        public void SetValue( int newValue){   Balance=newValue;     }
    }


