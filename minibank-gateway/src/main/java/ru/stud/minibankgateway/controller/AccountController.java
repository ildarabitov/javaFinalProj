package ru.stud.minibankgateway.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.stud.minibankgateway.VO.ClientNumber;
import ru.stud.minibankgateway.VO.Account;
import ru.stud.minibankgateway.VO.resp.BalanceByCardIdentifier;
import ru.stud.minibankgateway.VO.resp.ModificationOverAccount;
import ru.stud.minibankgateway.adapter.AccountAdapter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/account_gateway")
@Slf4j
@Validated
public class AccountController {
    @Autowired
    private AccountAdapter adapter;

    @PostMapping("/")
    @ApiOperation(value = "Creating a bank account by clientNumber",
            notes = "Provide customer clientNumber to create a bank account",
            response = Account.class)
    public Account createAccount(@RequestBody @Valid ClientNumber clientNumber) {
        log.info("Inside createAccount method of AccountController and arg = " + clientNumber);
        return adapter.createAccount(clientNumber);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Checking the account balance by cardIdentifier",
            notes = "provide a client cardIdentifier to get information about the account balance",
            response = BalanceByCardIdentifier.class)
    public BalanceByCardIdentifier checkBalance(@PathVariable("id")
                                                @NotNull
                                                @Size(min = 19, max = 19, message = " cardIdentifier must be equal to 20 characters")
                                                        String cardIdentifier) {
        log.info("Inside checkBalance method of AccountController and arg = " + cardIdentifier);
        return adapter.getBalance(cardIdentifier);

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Сlosing an account by cardIdentifier",
            notes = "provide client cardIdentifier for account closure",
            response = ModificationOverAccount.class)
    public ModificationOverAccount closeAccount(@PathVariable("id")
                                                @NotNull
                                                @Size(min = 19, max = 19, message = " cardIdentifier must be equal to 20 characters")
                                                        String cardIdentifier) {
        log.info("Inside closeAccount method of AccountController and arg = " + cardIdentifier);
        return adapter.closeAccount(cardIdentifier);
    }
}
