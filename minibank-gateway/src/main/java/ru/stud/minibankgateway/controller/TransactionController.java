package ru.stud.minibankgateway.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stud.minibankgateway.VO.Client;
import ru.stud.minibankgateway.VO.Transaction;
import ru.stud.minibankgateway.VO.dto.TransactionDTO;
import ru.stud.minibankgateway.VO.resp.ChangeOverBalance;
import ru.stud.minibankgateway.adapter.TransactionAdapter;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/transaction_gateway")
@Slf4j
public class TransactionController {
    @Autowired
    TransactionAdapter adapter;

    @PutMapping("/")
    @ApiOperation(value = "Payment and balance top-up",
            notes = "Provide the cardIdentifier data, the required operation:" +
                    " if the payment is PAY, if you want to top up the balance then BALANCE_REFILL," +
                    " the same amount to be debited or replenished",
            response = ChangeOverBalance.class)
    public ChangeOverBalance сhangeOverBalance(@Valid @RequestBody TransactionDTO transactionDTO) {
        log.info("Inside createClient method of ClientController and arg = " + transactionDTO);
        Transaction transaction=new Transaction(transactionDTO.getCardIdentifier(),transactionDTO.getBalance(),
                transactionDTO.getOperationType(), UUID.randomUUID().toString().replaceAll("-", "").substring(1,30));
        adapter.changeOverBalance(transaction);
        return new ChangeOverBalance(transaction.getOperationType().getValue(),"Success",transaction.getCardIdentifier(),transaction.getTransactionIdentifier());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Getting information on a transaction by transactionIdentifier",
            notes = "Provide the transactionIdentifier of the transaction to get full information on the conducted transaction",
            response = Transaction.class)
    public Transaction getTransactionById(@PathVariable("id") String transactionIdentifier) {
        log.info("Inside createClient method of ClientController and arg = " + transactionIdentifier);
        return adapter.getTransaction(transactionIdentifier);
    }
}
