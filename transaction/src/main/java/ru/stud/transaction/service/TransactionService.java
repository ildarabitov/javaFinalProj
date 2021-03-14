package ru.stud.transaction.service;

import ru.stud.transaction.entity.Transaction;

public interface TransactionService {
    void createOperationOverBalance(Transaction transaction);
    Transaction findByTransactionId(String transactionId);
}
