package fr.sg.kata.bankaccount;

import fr.sg.kata.bankaccount.repository.OperationRepository;
import fr.sg.kata.bankaccount.service.Account;
import fr.sg.kata.bankaccount.service.OperationHistoryPrinter;
import fr.sg.kata.bankaccount.utils.Console;

/**
 * This is the main class to make a demonstration for the usage of the programe BankAccount.
 */
public class BankAccountApp {
    public static void main(String[] args) {
        Console console = new Console();
        OperationRepository operationRepository = new OperationRepository();
        OperationHistoryPrinter operationHistoryPrinter = new OperationHistoryPrinter(console);
        Account account = new Account(operationRepository, operationHistoryPrinter);

        // Make deposit or withdrawal
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
        account.withdraw(300);

        // Check operations History
        account.checkOperationHistory();
    }
}
