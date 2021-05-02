package fr.sg.kata.bankaccount.entity;

import fr.sg.kata.bankaccount.utils.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * This class represents the transaction of client on his account.
 */
@AllArgsConstructor
@Getter
public class Operation {
    private final Date date;
    private final OperationType operationType;
    private final int amount;
}
