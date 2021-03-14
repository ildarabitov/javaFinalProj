package ru.stud.minibankgateway.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.stud.minibankgateway.VO.ClientNumber;
import ru.stud.minibankgateway.VO.Account;
import ru.stud.minibankgateway.VO.resp.BalanceByCardIdentifier;
import ru.stud.minibankgateway.VO.resp.ModificationOverAccount;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AccountAdapter {
    private static final String REQUESTS_ENDPOINT = "/account/";

    private final RestTemplate restTemplate;

    @Value("${account.url}")
    private String accountUrl;

    public AccountAdapter(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Account createAccount(ClientNumber clientNumber) {
        log.info("Inside createAccount method of AccountAdapter and arg = " + clientNumber);
        Account account = new Account();
        HttpEntity<Account> request = new HttpEntity<Account>(account);
        return restTemplate.postForObject(accountUrl + REQUESTS_ENDPOINT + clientNumber.getClientNumber(), request, Account.class);

    }

    public BalanceByCardIdentifier getBalance(String cardIdentifier) {
        log.info("Inside getBalance method of AccountAdapter and arg = "+ cardIdentifier);
        return restTemplate.getForObject(accountUrl + REQUESTS_ENDPOINT + cardIdentifier, BalanceByCardIdentifier.class);
    }

    public ModificationOverAccount closeAccount(String cardIdentifier) {
        log.info("Inside getBalance method of AccountAdapter and arg = "+ cardIdentifier);
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", cardIdentifier);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(accountUrl + REQUESTS_ENDPOINT + "/{id}", params);
        return new ModificationOverAccount("Close Account", "Success", cardIdentifier);

    }
}
