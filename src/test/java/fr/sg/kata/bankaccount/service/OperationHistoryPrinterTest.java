package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.entity.Operation;
import fr.sg.kata.bankaccount.utils.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static fr.sg.kata.bankaccount.service.OperationHistoryPrinter.OPERATION_HISTORY_HEADER;
import static fr.sg.kata.bankaccount.utils.OperationType.CREDIT;
import static fr.sg.kata.bankaccount.utils.OperationType.DEBIT;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OperationHistoryPrinterTest {

    private static final List<Operation> NO_OPERATIONS = EMPTY_LIST;
    @Mock
    Console console;

    @Test
    public void should_always_print_header(){
        // Arrange
        OperationHistoryPrinter operationHistoryPrinter = new OperationHistoryPrinter(console);
        // Act
        operationHistoryPrinter.print(NO_OPERATIONS);
        // Assert
        verify(console).printLine(OPERATION_HISTORY_HEADER);
    }

    @Test
    public void should_print_operations_in_happening_order() throws ParseException {
        // Arrange
        OperationHistoryPrinter operationHistoryPrinter = new OperationHistoryPrinter(console);
        List<Operation> operations = new ArrayList<>();
        operations.add(new Operation(OperationHistoryPrinter.SIMPLE_DATE_FORMAT.parse("01/03/2021"), CREDIT, 1000));
        operations.add(new Operation(OperationHistoryPrinter.SIMPLE_DATE_FORMAT.parse("02/03/2021"), DEBIT, 100));
        operations.add(new Operation(OperationHistoryPrinter.SIMPLE_DATE_FORMAT.parse("10/03/2021"), CREDIT, 500));
        operations.add(new Operation(OperationHistoryPrinter.SIMPLE_DATE_FORMAT.parse("12/03/2021"), DEBIT, 300));
        // Act
        operationHistoryPrinter.print(operations);
        // Assert
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine(OPERATION_HISTORY_HEADER);
        inOrder.verify(console).printLine("12/03/2021 |           |300,00     |1100,00");
        inOrder.verify(console).printLine("10/03/2021 |500,00     |           |1400,00");
        inOrder.verify(console).printLine("02/03/2021 |           |100,00     |900,00");
        inOrder.verify(console).printLine("01/03/2021 |1000,00    |           |1000,00");
    }
}