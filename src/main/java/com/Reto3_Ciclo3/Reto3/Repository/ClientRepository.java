package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>)  clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int client_id){
        return clientCrudRepository.findById(client_id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}