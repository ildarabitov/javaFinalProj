package ru.stud.transaction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stud.transaction.entity.Transaction;
import ru.stud.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PutMapping("/")
    public void createOperationOverBalance(@RequestBody Transaction transaction) {
        log.info("Inside createOperationWithBalance method of ClientController and arg = " + transaction);
        transactionService.createOperationOverBalance(transaction);
    }

    @GetMapping("/{id}")
    public Transaction findByTransactionId(@PathVariable("id") String transactionId) {
        log.info("Inside findByTransactionId method of ClientController and arg = " + transactionId);
        return transactionService.findByTransactionId(transactionId);
    }
}