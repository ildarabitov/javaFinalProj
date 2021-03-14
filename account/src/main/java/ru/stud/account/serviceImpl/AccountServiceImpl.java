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

    @Override
    public Account saveAccount(Long clientNumber) {
        log.info("Inside saveAccount method of AccountController arg = " + clientNumber);
        Client client = restTemplate.getForObject(clientUrl + REQUESTS_ENDPOINT + "/get_client/" + clientNumber, Client.class);
        Account account = new Account();
        account.setFirstName(client.getFirstName());
        account.setLastName(client.getLastName());
        account.setMiddleName(client.getMiddleNAme());
        account.setClientId(client.getClientId());
        account.setBalance(0.00);
        account.setClientNumber(client.getClientNumber());
        account.setCardIdentifier(UUID.randomUUID().toString().replaceAll("-", "").substring(1,20));
        log.info("Inside saveAccount method of AccountController account = " + account);
        return repository.save(account);
    }

    @Override
    public Account findByAccountId(Long accountId) {
        log.info("Inside findByAccountId of AccountServiceImpl arg = "+accountId);
        return repository.findByAccountId(accountId);
    }

    @Override
    public BalanceByCardIdentifier balanceByCardIdentifier(String cardIdentifier) {
        log.info("Inside getBalanceByCardIdentifier of AccountServiceImpl arg = "+cardIdentifier);
        Account account=repository.findByCardIdentifier(cardIdentifier);
        BalanceByCardIdentifier balanceInfo=new BalanceByCardIdentifier(account.getCardIdentifier(),account.getBalance());
        return balanceInfo;
    }
    public void deleteAccount(String cardIdentifier){
        Account account=repository.findByCardIdentifier(cardIdentifier);
        repository.delete(account);
    }

    @Override
    public void updateAccountBalance(Transaction transaction) {
        Account account=repository.findByCardIdentifier(transaction.getCardIdentifier());;
        if (transaction.getOperationType().equals(OperationType.PAY)){
           account.setBalance(account.getBalance()-transaction.getBalance());
        }else if (transaction.getOperationType().equals(OperationType.BALANCE_REFILL))
        account.setBalance(account.getBalance()+transaction.getBalance());
        repository.save(account);
    }


}
