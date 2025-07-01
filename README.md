#  Bank Account Simulation

A simple Java console application simulating basic banking operations, including account creation with password protection, secure login, deposits, withdrawals, and transaction history.

---

## ✨ Features
✅ Create multiple user accounts  
✅ Password authentication for secure login  
✅ Deposit and withdraw money  
✅ View detailed transaction history  
✅ Simple text-based menu interface  

📝 Usage
Create Account – Enter a unique username, set a password, and initial balance.

Login – Enter existing username and password to access your account.

Deposit – Add money to your account.

Withdraw – Take money out of your account.

Show Transaction History – View a log of all transactions performed on the account.

Logout/Exit – Log out of the current account or exit the application entirely.

🛠 Concepts Used
This project demonstrates several core Java and OOP concepts:

Classes and Objects – Defined Account and BankSystem classes, and created account objects.

Encapsulation – Used private fields with public methods to control access to account data.

Methods – Implemented deposit(), withdraw(), printTransactionHistory(), etc.

Collections – Used ArrayList for storing transactions and HashMap for storing multiple accounts.

User Input – Used Scanner for reading user choices and account information.

Control Structures – Implemented loops (while) and conditionals (if-else, switch) for menu navigation.

Strings – Managed user names, passwords, and transaction logs.

Basic Authentication – Added password-based login for account security.

Data Validation – Checked for invalid deposit/withdraw amounts and existing usernames.

Console Interaction – Built a simple, text-based interface for user interaction.

