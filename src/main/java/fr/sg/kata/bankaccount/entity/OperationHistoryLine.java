package fr.sg.kata.bankaccount.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OperationHistoryLine {
    private final Operation operation;
    // current balance
    private final int balance;
}
