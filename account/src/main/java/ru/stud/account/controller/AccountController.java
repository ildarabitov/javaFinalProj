package ru.stud.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stud.account.VO.Transaction;
import ru.stud.account.VO.resp.BalanceByCardIdentifier;
import ru.stud.account.entity.Account;
import lombok.extern.slf4j.Slf4j;
import ru.stud.account.serviceImpl.AccountServiceImpl;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/{id}")
    public Account saveAccount(@PathVariable("id") Long clientNumber) {
        log.info("Inside saveAccount method of AccountController arg = " + clientNumber);
        return accountService.saveAccount(clientNumber);
    }

    @GetMapping("/{id}")
    public BalanceByCardIdentifier checkAccountBalance(@PathVariable("id") String cardIdentifier) {
        log.info("Inside checkAccountBalance method of AccountController arg = " + cardIdentifier);
        return accountService.balanceByCardIdentifier(cardIdentifier);
    }

    @DeleteMapping("/{id}")
    public void closeAccount(@PathVariable("id") String cardIdentifier) {
        log.info("Inside closeAccount method of AccountController arg = " + cardIdentifier);
        accountService.deleteAccount(cardIdentifier);
    }

    @PutMapping("/")
    public void updateAccountBalance(@RequestBody Transaction transaction) {
        log.info("Inside updateAccountBalance method of AccountController arg = " + transaction);
        accountService.updateAccountBalance(transaction);

    }
}
