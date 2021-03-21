package ru.stud.account.serviceImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.stud.account.AccountApplication;
import ru.stud.account.VO.Client;
import ru.stud.account.entity.Account;
import ru.stud.account.repository.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
class AccountServiceImplTest {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    private static final String REQUESTS_ENDPOINT = "/client/";
    @Value("${client.url}")
    private String clientUrl;
    @Test
    void saveAccount() {
        Account account=new Account();
        account.setBalance(0.00);
        account.setClientId((long) 1);
        account.setMiddleName("dsfsdf");
        account.setFirstName("dfdfss");
        account.setLastName("dsfssdddf");
        account.setCardIdentifier("324545534");
        account.setClientNumber("425435");
        repository.save(account);
        AccountServiceImpl service=new AccountServiceImpl();
//        System.out.println(service.isExistAccount(account));

    }

    @Test
    void findByAccountId() {
    }

    @Test
    void balanceByCardIdentifier() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void updateAccountBalance() {
    }
}