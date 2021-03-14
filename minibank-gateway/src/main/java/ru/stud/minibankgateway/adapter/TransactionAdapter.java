package ru.stud.minibankgateway.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.stud.minibankgateway.VO.ClientNumber;
import ru.stud.minibankgateway.VO.Account;
import ru.stud.minibankgateway.VO.Transaction;
import ru.stud.minibankgateway.VO.dto.TransactionDTO;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TransactionAdapter {
    private static final String REQUESTS_ENDPOINT = "/transaction/";

    private final RestTemplate restTemplate;

    @Value("${transaction.url}")
    private String transactionUrl;

    public TransactionAdapter(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public void changeOverBalance(Transaction transaction) {
        log.info("Inside createOperation method of TransactionAdapter and arg = " + transaction);
        restTemplate.put(transactionUrl + REQUESTS_ENDPOINT , transaction);
    }
    public Transaction getTransaction(String transactionId){
        log.info("Inside getTransaction method of TransactionAdapter and arg = " + transactionId);

        return restTemplate.getForObject(transactionUrl + REQUESTS_ENDPOINT+transactionId,Transaction.class);
    }
}
