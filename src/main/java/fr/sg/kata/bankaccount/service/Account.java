package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.repository.OperationRepository;
import lombok.AllArgsConstructor;
import static fr.sg.kata.bankaccount.utils.OperationType.CREDIT;
import static fr.sg.kata.bankaccount.utils.OperationType.DEBIT;

@AllArgsConstructor
public class Account {
    private final OperationRepository operationRepository;
    private final OperationHistoryPrinter operationHistoryPrinter;

    public void deposit(int amount) {
        operationRepository.saveOperation(amount, CREDIT);
    }

    public void withdraw(int amount) {
        operationRepository.saveOperation(amount, DEBIT);
    }

    public void checkOperationHistory() {
        operationHistoryPrinter.print(operationRepository.getAllOperations());
    }
}
