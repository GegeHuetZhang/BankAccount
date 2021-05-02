## My solution
To test the programe, compile all the java classes, execute the Main "BankAccountApp.java".
You will see the test example for the three user stories.

I have started from defining an acceptance test:

> Given a client makes a deposit of 1000 on 01-03-2021  
And a withdrawal of 100 on 02-03-2021  
And a deposit of 500 on 10-03-2021       
When the client prints his or her bank statement  
Then client would see
<pre>
Date       |Credit     |Debit      |Balance  
12/03/2021 |           |300,00     |1100,00  
10/03/2021 |500,00     |           |1400,00  
02/03/2021 |           |100,00     |900,00  
01/03/2021 |1000,00    |           |1000,00
</pre>

# Bank account kata

Think of your personal bank account experience When in doubt, go for the simplest solution

## Requirements

· Deposit and Withdrawal

· Account statement (date, amount, balance)

· Statement printing

## User Stories

##### **US 1:**

In order to save money As a bank client I want to make a deposit in my account

##### **US 2:**

In order to retrieve some or all of my savings As a bank client I want to make a withdrawal from my account

##### **US 3:**

In order to check my operations As a bank client I want to see the history (operation, date, amount, balance) of my operations
