package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.repository.OperationRepository;
import fr.sg.kata.bankaccount.utils.OperationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    @Mock
    private OperationRepository operationRepository;
    private Account account;

    @Before
    public void setUp() {
        account = new Account(operationRepository);
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
}