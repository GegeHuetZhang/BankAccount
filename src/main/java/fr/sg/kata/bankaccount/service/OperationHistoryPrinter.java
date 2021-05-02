package fr.sg.kata.bankaccount.service;

import fr.sg.kata.bankaccount.entity.Operation;
import fr.sg.kata.bankaccount.entity.OperationHistoryLine;
import fr.sg.kata.bankaccount.utils.Console;
import lombok.AllArgsConstructor;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static fr.sg.kata.bankaccount.utils.OperationType.CREDIT;
import static fr.sg.kata.bankaccount.utils.OperationType.DEBIT;
import static java.util.Collections.reverse;
import static org.codehaus.plexus.util.StringUtils.rightPad;


/**
 * This class allows client to print operations history.
 */
@AllArgsConstructor
public class OperationHistoryPrinter {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String SEPERATOR = " |";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    public static final String OPERATION_HISTORY_HEADER = "Date       |Credit     |Debit      |Balance";
    public static final int INITIAL_BALANCE = 0;
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    public static final int FIELD_SIZE = 10;
    public static final String EMPTY_FIELD = "          ";

    private final Console console;

    /**
     * This method allows to print the operations history of client.
     * @param operations the list of operations of client on his account
     */
    public void print(List<Operation> operations) {
        console.printLine(OPERATION_HISTORY_HEADER);
        List<OperationHistoryLine> operationHistory = transformToOperationHistoryLines(operations);
        reverse(operationHistory);
        operationHistory.forEach(operationHistoryLine -> console.printLine(createOperationHistoryLine(operationHistoryLine)));
    }

    /**
     * This method allows to transform a list of Operation to a list of OperationHistoryLine
     * @param operations the list of operations of account
     * @return a list of OperationHistoryLine
     */
    private List<OperationHistoryLine> transformToOperationHistoryLines(List<Operation> operations) {
        List<OperationHistoryLine> operationHistoryLines = new ArrayList<>();
        int currentBalance = INITIAL_BALANCE;

        for (Operation operation : operations) {
            currentBalance = calculateCurrentOperationBalance(currentBalance, operation);
            operationHistoryLines.add(new OperationHistoryLine(operation, currentBalance));
        }
        return operationHistoryLines;
    }

    /**
     * This method allows to calculate the current balance of account after current operation for client.
     * @param balance initial balance before current operation
     * @param operation the current operation
     * @return current balance to present in {@link fr.sg.kata.bankaccount.entity.OperationHistoryLine}
     */
    private int calculateCurrentOperationBalance(int balance, Operation operation) {
        if (DEBIT == operation.getOperationType()) balance -= operation.getAmount();
        else if (CREDIT == operation.getOperationType()) balance += operation.getAmount();
        return balance;
    }

    /**
     * This method create the transaction information to be showed on one history line.
     * @param operationHistoryLine {@link fr.sg.kata.bankaccount.entity.OperationHistoryLine}
     * @return a string of operation date, credit or debit and current balance
     */
    private String createOperationHistoryLine(OperationHistoryLine operationHistoryLine) {
        return CREDIT == operationHistoryLine.getOperation().getOperationType() ?
                createDepositOperationHistoryLine(operationHistoryLine) :
                createWithdrawOperationHistoryLine(operationHistoryLine);
    }

    /**
     * This method create the deposit transaction information.
     * @param operationHistoryLine {@link fr.sg.kata.bankaccount.entity.OperationHistoryLine}
     * @return a string of operation date, credit and current balance
     */
    private String createDepositOperationHistoryLine(OperationHistoryLine operationHistoryLine) {
        return getOperationDateField(operationHistoryLine)
                + SEPERATOR + getOperationAmountField(operationHistoryLine)
                + SEPERATOR + EMPTY_FIELD
                + SEPERATOR + getCurrentBalanceField(operationHistoryLine);
    }
    /**
     * This method create the withdraw transaction information.
     * @param operationHistoryLine {@link fr.sg.kata.bankaccount.entity.OperationHistoryLine}
     * @return a string of operation date, debit and current balance
     */
    private String createWithdrawOperationHistoryLine(OperationHistoryLine operationHistoryLine) {
        return getOperationDateField(operationHistoryLine)
                + SEPERATOR + EMPTY_FIELD
                + SEPERATOR + getOperationAmountField(operationHistoryLine)
                + SEPERATOR + getCurrentBalanceField(operationHistoryLine);
    }

    /**
     * This method allows to transform operation history line balance in wanted format.
     * @param operationHistoryLine {@link fr.sg.kata.bankaccount.entity.OperationHistoryLine}
     * @return balance in wanted format
     */
    private String getCurrentBalanceField(OperationHistoryLine operationHistoryLine) {
        return DECIMAL_FORMAT.format(operationHistoryLine.getBalance());
    }

    /**
     * This method allows to transform operation amount in wanted format.
     * @param operationHistoryLine {@link fr.sg.kata.bankaccount.entity.OperationHistoryLine}
     * @return operation amount in wanted format.
     */
    private String getOperationAmountField(OperationHistoryLine operationHistoryLine) {
        return rightPad(DECIMAL_FORMAT.format(operationHistoryLine.getOperation().getAmount()), FIELD_SIZE);
    }


    private String getOperationDateField(OperationHistoryLine operationHistoryLine) {
        return SIMPLE_DATE_FORMAT.format(operationHistoryLine.getOperation().getDate());
    }
}
