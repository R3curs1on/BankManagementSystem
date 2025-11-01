# Bank Management System

Simple console-based bank management system in Java. Supports creating accounts, logging in, checking balances, crediting/debiting accounts, and deleting accounts. Accounts are stored in-memory (HashMap) and passwords are stored as SHA-256 hashes.

## Features
- Create account (name, numeric password, optional initial balance)
- Login using account number + password
- Check balance, credit (deposit), debit (withdraw)
- Delete account
- Account numbers are randomly generated and passwords are hashed using SHA-256

## Prerequisites
- Java Development Kit (JDK) 8+ installed
- Basic command line knowledge or an IDE (IntelliJ IDEA, Eclipse)

## Build & Run (command line)
From the repository root (project folder):

1. Compile all sources:
   Windows:
   ```
   javac -d out src\*.java
   ```
   Linux / macOS:
   ```
   javac -d out src/*.java
   ```

2. Run the program:
   ```
   java -cp out Main
   ```

You can also open the project in your IDE and run the `Main` class.

## Usage (quick)
On startup you will see the main menu:
1. Create Account
2. Login
3. Exit

Create account prompts:
- name
- password (minimum 4 characters)
- initial balance (optional, non-negative number)

After creating an account you receive an account number (e.g., AC...).

Login prompts:
- Account Number
- Password

Once logged in, account menu provides:
- Check Balance
- Credit (deposit)
- Debit (withdraw)
- Delete Account
- Logout

## Example flow
Create account:
- enter name: John Doe
- enter password: 1234
- enter initial balance: 500
- Output: Successfully created Account! Your new Account Number is: AC...

Login & operations:
- enter Account Number: AC...
- enter password: 1234
- After login:
  - (1) Check Balance → shows current balance
  - (2) Credit → add funds
  - (3) Debit → withdraw funds
  - (4) Delete Account → removes account from memory
  - (5) Logout → returns to main menu

## Code structure
- src/
  - Main.java — main CLI and program flow
  - NewAccount.java — account model (password hashed, balance handling)
  - AccountMap.java — in-memory HashMap storage for accounts
  - Login.java — authentication helper
  - HashUtil.java — SHA-256 hashing helper

## Notes & limitations
- Storage: accounts are stored in memory (HashMap). Closing the program clears all accounts. Persistent storage is not implemented.
- Security: passwords are hashed with SHA-256, but this is a simple example — no salt and no secure password storage best practices are implemented.
- Account numbers are generated using UUID and prefixed with `AC`.

## Contributing
Improvements you might add:
- Persistent storage (file or database)
- Salted/strong password storage
- Better input validation and UI
- Unit tests and logging

## License
Use or modify as you wish. No license file included by default.
