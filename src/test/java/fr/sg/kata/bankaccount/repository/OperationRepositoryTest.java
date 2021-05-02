package fr.sg.kata.bankaccount.repository;

import fr.sg.kata.bankaccount.entity.Operation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OperationRepositoryTest {
    private OperationRepository operationRepository;
    @Before
    public void setUp() throws Exception {
        operationRepository = new OperationRepository();
    }
    @Test
    public void should_create_and_save_a_deposit_operation() throws Exception {
        // Arrange
        operationRepository.saveOperation(100);
        // Act
        List<Operation> operations = operationRepository.getAllOperations();
        // Assert
        assertEquals(operations.size(), 1);
        assertEquals(operations.get(0).getAmount(), 100);
    }
}