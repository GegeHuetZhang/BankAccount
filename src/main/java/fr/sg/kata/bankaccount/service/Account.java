package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.repository.OperationRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {
    private final OperationRepository operationRepository;
    public void deposit(int amount) throws Exception {
        operationRepository.saveOperation(amount);
    }
}
