package fr.sg.kata.bankaccount.repository;

import fr.sg.kata.bankaccount.entity.Operation;
import fr.sg.kata.bankaccount.utils.OperationType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationRepository {
    private final List<Operation> operations = new ArrayList<>();

    /**
     * This method allows to save an operation of client on his account.
     * @param amount the amount of money for a created operation.
     * @param operationType {@link fr.sg.kata.bankaccount.utils.OperationType}
     */
    public void saveOperation(int amount, OperationType operationType) {
        operations.add(new Operation(new Date(), operationType, amount));
    }

    /**
     * This method allows to get all the operations of client on his account.
     * @return list of operations
     */
    public List<Operation> getAllOperations() {
        return operations;
    }
}
