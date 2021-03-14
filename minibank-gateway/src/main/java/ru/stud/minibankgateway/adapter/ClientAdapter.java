package ru.stud.minibankgateway.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.stud.minibankgateway.VO.Client;

@Service
@Slf4j
public class ClientAdapter {
    private static final String REQUESTS_ENDPOINT = "/client/";

    private final RestTemplate restTemplate;

    @Value("${client.url}")
    private String clientUrl;

    public ClientAdapter(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Client createClient(Client client) {
        log.info("Inside createClient method of ClientAdapter and arg = " + client);
        HttpEntity<Client> request = new HttpEntity<Client>(client);
        return restTemplate.postForObject(clientUrl + REQUESTS_ENDPOINT, request, Client.class);

    }
}
