public class LinkedList {
        private NewAccount head;  //head of the linked list ; head is the first node of the linked list

        public  LinkedList(){  this.head=null;    }     //constructor to create a new linked list ;
        // analogy : this is a closed Conatiner /box to store the Garlands ;
        //Flowers are the nodes ; the thread that ties the flowers Reference ;
        //the 1st thread that connect end of container to the first flower is the head

        public boolean isEmpty(){       return head==null;    }  //method to check if the linked list is empty ;
        //analogy : if the container is empty or not    ;
        // if first thread is connected to the first flower or not

        public void add(NewAccount newAccount){          //method to insert a new node in the linked list ; new flower in the container at end
            if (isEmpty()) {                                //if the linked list is empty ; insert the new node at the start of the linked list
                head=newAccount;                            //the first thread is connected to the first flower
            }
            else{                                           //if the linked list is not empty
                NewAccount checker=head;                // a temporary node to traverse the linked list  // we insert new thread from start head to end flower
                while (checker.next!=null) {            //loop to reach the end of the linked list
                    checker=checker.next;
                }
                checker.next=newAccount;                //inserting the new node at the end of the linked list
                newAccount.next=null;
            }
        }

        public  NewAccount search(String AccountNumber){       //method to search a node in the linked list
            NewAccount checker=head;                            // a temporary node to traverse the linked list
            while (checker!=null && !checker.displayAccountNumber().equals(AccountNumber) ) {    checker=checker.next;}  //loop to traverse the linked list
            return checker;     //return the node if found ; else return null
        }

        public  void delete(String AccountNumber){       //method to delete a node in the linked list
            if (isEmpty()) {                            //if the linked list is empty ; return
                return;
            }
            if (head.displayAccountNumber().equals(AccountNumber)) {    //if the node to be deleted is the first node
                head=head.next;                                         //delete the first node
                return;
            }
            NewAccount found=search(AccountNumber);                                    // a temporary node to traverse the linked list
            found.next=found.next.next;                                             //delete the node
        }

    }


