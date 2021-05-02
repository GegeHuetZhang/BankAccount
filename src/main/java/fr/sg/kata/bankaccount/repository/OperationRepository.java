package fr.sg.kata.bankaccount.repository;

import fr.sg.kata.bankaccount.entity.Operation;
import fr.sg.kata.bankaccount.utils.OperationType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationRepository {
    private final List<Operation> operations = new ArrayList<>();

    public void saveOperation(int amount, OperationType operationType) {
        operations.add(new Operation(new Date(), operationType, amount));
    }

    public List<Operation> getAllOperations() {
        return operations;
    }
}
