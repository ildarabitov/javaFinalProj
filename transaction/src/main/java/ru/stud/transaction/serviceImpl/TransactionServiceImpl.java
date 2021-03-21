package ru.stud.transaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.stud.transaction.entity.Transaction;
import ru.stud.transaction.repository.TransactionRepository;
import ru.stud.transaction.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${account.url}")
    private String accountUrl;
    @Override
    public void createOperationOverBalance(Transaction transaction) {
        restTemplate.put(accountUrl,transaction);
        repository.save(transaction);
    }

    @Override
    public Transaction findByTransactionId(String transactionId) {
        return repository.findByTransactionIdentifier(transactionId);
    }
}
