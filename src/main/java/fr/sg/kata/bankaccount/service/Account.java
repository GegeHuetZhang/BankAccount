package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.repository.OperationRepository;
import fr.sg.kata.bankaccount.utils.OperationType;
import lombok.AllArgsConstructor;

import static fr.sg.kata.bankaccount.utils.OperationType.CREDIT;
import static fr.sg.kata.bankaccount.utils.OperationType.DEBIT;

@AllArgsConstructor
public class Account {
    private final OperationRepository operationRepository;
    public void deposit(int amount) {
        operationRepository.saveOperation(amount, CREDIT);
    }

    public void withdraw(int amount) {
        operationRepository.saveOperation(amount, DEBIT);
    }
}
