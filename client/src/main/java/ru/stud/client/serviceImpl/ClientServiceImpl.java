package ru.stud.client.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stud.client.entity.Client;
import ru.stud.client.repository.ClientRepository;
import ru.stud.client.service.ClientService;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public Client findByClientNumber(String clientNumber) {
        log.info("Inside findByClientNumber method of ClientServiceImpl and arg = " + clientNumber);
        return repository.findByClientNumber(clientNumber);
    }

    public Client saveClient(Client client) {
        Client client1=new Client();
        try {
            if ((client1=repository.findByClientNumber(client.getClientNumber()))!=null){
                System.out.println("dfsfdfsdfsdff");
                return client1;
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }
        log.info("Inside saveClient method of ClientServiceImpl and arg = " + client);
        return repository.save(client);
    }
}
