package ru.stud.client.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.stud.client.ClientApplication;
import ru.stud.client.entity.Client;
import ru.stud.client.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
class ClientControllerTest {
    @Autowired
    ClientRepository repository;

    @Test
    void saveClient() {
        Client client=new Client();
        client.setClientNumber( 791765610L);
        client.setFirstName("Anton");
        client.setLastName("Antonov");
        client.setMiddleNAme("Antonovich");
        repository.save(client);
        Client client1=repository.findByClientNumber(791765610L);
        assertTrue(client1!=null);
        assertEquals(client1.getFirstName(),client.getFirstName());
        assertEquals(client1.getLastName(),client.getLastName());
        assertEquals(client1.getMiddleNAme(),client.getMiddleNAme());
    }

    @Test
    void findByClientNumber() {
    }
}