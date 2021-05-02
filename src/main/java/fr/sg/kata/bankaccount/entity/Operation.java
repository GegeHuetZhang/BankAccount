package fr.sg.kata.bankaccount.entity;

import fr.sg.kata.bankaccount.utils.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Operation {
    private final OperationType operationType;
    private final int amount;
}
