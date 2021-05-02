package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.entity.Operation;
import fr.sg.kata.bankaccount.repository.OperationRepository;
import fr.sg.kata.bankaccount.utils.OperationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    @Mock
    private OperationRepository operationRepository;
    @Mock
    private OperationHistoryPrinter operationHistoryPrinter;
    private Account account;

    @Before
    public void setUp() {
        account = new Account(operationRepository, operationHistoryPrinter);
    }

    @Test
    public void should_save_a_deposit_operation() throws Exception {
        // Arrange & Act
        account.deposit(100);
        // Assert
        verify(operationRepository).saveOperation(100, OperationType.CREDIT);
    }

    @Test
    public void should_save_a_withdrawal_operation() throws Exception {
        // Arrange & Act
        account.withdraw(100);
        // Assert
        verify(operationRepository).saveOperation(100, OperationType.DEBIT);
    }

    @Test
    public void should_check_operation_history() {
        // Arrange
        List<Operation> operations = new ArrayList<>();
        operations.add(new Operation(null, null, 0));
        given(operationRepository.getAllOperations()).willReturn(operations);
        // Act
        account.checkOperationHistory();
        // Assert
        verify(operationHistoryPrinter).print(operations);
    }
}