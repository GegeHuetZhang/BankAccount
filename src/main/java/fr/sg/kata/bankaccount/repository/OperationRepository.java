package fr.sg.kata.bankaccount.repository;

import fr.sg.kata.bankaccount.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationRepository {
    private final List<Operation> operations = new ArrayList<>();

    public void saveOperation(int amount) throws Exception {
        operations.add(new Operation(amount));
    }

    public List<Operation> getAllOperations() {
        return operations;
    }
}
