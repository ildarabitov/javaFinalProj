package ru.stud.account.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.stud.account.VO.Client;
import ru.stud.account.VO.Transaction;
import ru.stud.account.VO.resp.BalanceByCardIdentifier;
import ru.stud.account.VO.util.OperationType;
import ru.stud.account.entity.Account;
import lombok.extern.slf4j.Slf4j;
import ru.stud.account.repository.AccountRepository;
import ru.stud.account.service.AccountService;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    private static final String REQUESTS_ENDPOINT = "/client/";
    @Value("${client.url}")
    private String clientUrl;

    //    public boolean isExistAccount(Account account){
//        return (repository.findByClientNumber(account.getCardIdentifier()))!=null;
//    }
    @Override
    public Account saveAccount(String clientNumber) {
        Account account = new Account();
        try {
            account = repository.findByClientNumber(clientNumber);
            if (account.getClientNumber() != null) {
                return account;
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        log.info("Inside saveAccount method of AccountController arg = " + clientNumber);
        Client client = restTemplate.getForObject(clientUrl + REQUESTS_ENDPOINT + "/get_client/" + clientNumber, Client.class);
        Account account1 = new Account();
        account1.setFirstName(client.getFirstName());
        account1.setLastName(client.getLastName());
        account1.setMiddleName(client.getMiddleNAme());
        account1.setClientId(client.getClientId());
        account1.setBalance(0.00);
        account1.setClientNumber(client.getClientNumber());
        account1.setCardIdentifier(UUID.randomUUID().toString().replaceAll("-", "").substring(1, 20));
        log.info("Inside saveAccount method of AccountController account = " + account1);
        return repository.save(account1);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        log.info("Inside findByAccountId of AccountServiceImpl arg = " + accountId);
        return repository.findByAccountId(accountId);
    }

    @Override
    public BalanceByCardIdentifier balanceByCardIdentifier(String cardIdentifier) {
        log.info("Inside getBalanceByCardIdentifier of AccountServiceImpl arg = " + cardIdentifier);
        Account account = repository.findByCardIdentifier(cardIdentifier);
        BalanceByCardIdentifier balanceInfo = new BalanceByCardIdentifier(account.getCardIdentifier(), account.getBalance());
        return balanceInfo;
    }

    public void deleteAccount(String cardIdentifier) {
        Account account = repository.findByCardIdentifier(cardIdentifier);
        repository.delete(account);
    }

    @Override
    public void updateAccountBalance(Transaction transaction) {
        Account account = repository.findByCardIdentifier(transaction.getCardIdentifier());
        ;
        if (transaction.getOperationType().equals(OperationType.PAY)) {
            account.setBalance(account.getBalance() - transaction.getBalance());
        } else if (transaction.getOperationType().equals(OperationType.BALANCE_REFILL))
            account.setBalance(account.getBalance() + transaction.getBalance());
        repository.save(account);
    }


}
