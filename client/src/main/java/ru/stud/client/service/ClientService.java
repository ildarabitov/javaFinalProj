package ru.stud.client.service;

import ru.stud.client.entity.Client;

public interface ClientService {
    Client findByClientNumber(Long clientNumber);
    Client saveClient(Client client);
}
