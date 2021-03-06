package ru.stud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.stud.client.entity.Client;
import ru.stud.client.serviceImpl.ClientServiceImpl;

import javax.validation.Valid;


@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/")
    public Client saveClient(@Valid @RequestBody  Client client) {
        log.info("Inside saveClient method of ClientController and arg = "+client);

        return clientService.saveClient(client);
    }

    @GetMapping("/get_client/{id}")
    public Client findByClientNumber(@PathVariable("id") String clientNumber) {
        log.info("Inside findByClientNumber method of ClientController and arg = "+ clientNumber);
        return clientService.findByClientNumber(clientNumber);
    }
}
