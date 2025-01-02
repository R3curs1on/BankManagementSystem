Bank Management System

This is a simple console-based bank management system written in Java. The system allows users to create accounts, log in, check their balance, and perform credit and debit operations. It uses a LinkedList to store account information and allows for basic banking operations.
Functionality

    Create Account: Users can create a new account by providing a name, password, and an optional initial balance.
    Account Number is Unique and large
    Login to Account: Users can log in to their existing accounts using their account number and password.
    Account Operations: After logging in, users can perform the following operations:
        Check Balance: View the current balance of their account.
        Credit: Add money to their account.
        Debit: Withdraw money from their account.
        Delete Account: Delete their account permanently.
    Exit: Users can exit the system at any time.

Getting Started
Prerequisites

    Java Development Kit (JDK): Ensure you have Java installed on your machine.

Running the Program

    Clone the repository:


git clone https://github.com/your-username/BankManagementSystem.git

Compile the Java code:

``
javac Main.java
``

Run the program:

bash

    java Main

Usage

    On running the program, you will be presented with the following options:

    bash

    enter a choice :
    (1). Create Account
    (2). Login
    (3). Exit

    Follow the prompts to create an account or log in to an existing account.

    After logging in, you can check your balance, perform credit or debit operations, or delete your account.

Example Flow

    Creating an Account:

    yaml

enter name : John Doe

enter password in number: 1234 

enter balance (Optional): 500

Successfully created Account

Account Number: AC3512c523838ad93a12327ce8520bc86b66c1973f4d86b595114c33bbb59a032b

Logging in and Performing Operations:


    enter Account Number : AC3512c523838ad93a12327ce8520bc86b66c1973f4d86b595114c33bbb59a032b
    enter password in Number : 1234
    Account exists
    Welcome to your account, John Doe
    enter a choice :
    (0). Delete Account
    (1). Check Balance
    (2). Credit
    (3). Debit
    (4). Exit

Code Structure

    Main.java: This is the main class that runs the program and handles user interactions.
    NewAccount.java : This class is like Node Class of linkedlist , its used for storing name ,acc_number ,balence ,passwd(hashed)
    LinkedList.java : The actual linkedlist implementation ; this is where NewAccount.java objects (i mean Nodes ) are added,searched and deleted ; this class is used internally in account management 
    Account Management: The account management logic, such as creating accounts, logging in, crediting, debiting, and deleting accounts, is handled via the Login and CreateAccount classes .
    Hashutil.java : its SHA256 hashing class for creating unique account number and storing passwd as hash 
