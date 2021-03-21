package ru.stud.minibankgateway.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stud.minibankgateway.VO.Account;
import ru.stud.minibankgateway.VO.Client;
import ru.stud.minibankgateway.adapter.ClientAdapter;

import javax.validation.Valid;


@RestController
@RequestMapping("/client_gateway")
@Slf4j
public class ClientController {
    @Autowired
    ClientAdapter adapter;
    /**Create new client**/
    @PostMapping("/")
    @ApiOperation(value = "Creating client",
            notes = "Create a client provide the required information by fields",
            response = Client.class)
    public Client createClient(@Valid @RequestBody Client client) {
        log.info("Inside createClient method of ClientController and arg = " + client);
        return  adapter.createClient(client);
    }
}
