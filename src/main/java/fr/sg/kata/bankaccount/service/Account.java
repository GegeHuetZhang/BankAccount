package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.repository.OperationRepository;
import lombok.AllArgsConstructor;
import static fr.sg.kata.bankaccount.utils.OperationType.CREDIT;
import static fr.sg.kata.bankaccount.utils.OperationType.DEBIT;

/**
 * This class allows client to make operations on his account.
 */
@AllArgsConstructor
public class Account {
    private final OperationRepository operationRepository;
    private final OperationHistoryPrinter operationHistoryPrinter;

    /**
     * This method allows client to make a deposit on their account.
     * @param amount amount of saving deposited by client
     */
    public void deposit(int amount) {
        operationRepository.saveOperation(amount, CREDIT);
    }

    /**
     * This method allows client to make a withdrawal on their account.
     * @param amount amount of money retrieved by client
     */
    public void withdraw(int amount) {
        operationRepository.saveOperation(amount, DEBIT);
    }

    /**
     * This method allows client to print their operations history.
     */
    public void checkOperationHistory() {
        operationHistoryPrinter.print(operationRepository.getAllOperations());
    }
}
