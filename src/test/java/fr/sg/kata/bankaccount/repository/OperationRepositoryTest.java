package fr.sg.kata.bankaccount.repository;

import fr.sg.kata.bankaccount.entity.Operation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static fr.sg.kata.bankaccount.utils.OperationType.CREDIT;
import static fr.sg.kata.bankaccount.utils.OperationType.DEBIT;
import static org.junit.Assert.*;

public class OperationRepositoryTest {

    private OperationRepository operationRepository;

    @Before
    public void setUp() {
        operationRepository = new OperationRepository();
    }

    @Test
    public void should_create_and_save_a_deposit_operation() {
        // Arrange
        operationRepository.saveOperation(100, CREDIT);
        // Act
        List<Operation> operations = operationRepository.getAllOperations();
        // Assert
        assertEquals(operations.size(), 1);
        assertEquals(operations.get(0).getOperationType(), CREDIT);
        assertEquals(operations.get(0).getAmount(), 100);
    }

    @Test
    public void should_create_and_save_a_withdraw_operation() {
        // Arrange
        operationRepository.saveOperation(100, DEBIT);
        // Act
        List<Operation> operations = operationRepository.getAllOperations();
        // Assert
        assertEquals(operations.size(), 1);
        assertEquals(operations.get(0).getOperationType(), DEBIT);
        assertEquals(operations.get(0).getAmount(), 100);
    }
}