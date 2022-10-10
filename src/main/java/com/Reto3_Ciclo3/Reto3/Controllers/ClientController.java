package com.Reto3_Ciclo3.Reto3.Controllers;

import com.Reto3_Ciclo3.Reto3.Models.Client;
import com.Reto3_Ciclo3.Reto3.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClients(){
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int client_id){
        return clientService.getClient(client_id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody Client client){
        return  clientService.inserClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteClient(@PathVariable("id") int client_id){
        return clientService.deleteClient(client_id);
    }
}
