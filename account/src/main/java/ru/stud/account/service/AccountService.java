package ru.stud.account.service;

import ru.stud.account.VO.Transaction;
import ru.stud.account.VO.resp.BalanceByCardIdentifier;
import ru.stud.account.entity.Account;

public interface AccountService {
    Account saveAccount(String clientNumber);
    Account findByAccountId(Long clientBankId);
    BalanceByCardIdentifier balanceByCardIdentifier(String cardIdentifier);
    void deleteAccount(String cardIdentifier);
    void updateAccountBalance(Transaction transaction);
}
