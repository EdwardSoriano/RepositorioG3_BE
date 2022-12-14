package com.Reto3_Ciclo3.Reto3.Service;

import com.Reto3_Ciclo3.Reto3.Models.Client;
import com.Reto3_Ciclo3.Reto3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int client_id){
        return clientRepository.getClient(client_id);
    }

    public Client inserClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(Client client){
        if (client.getIdClient() != null){
            Optional<Client> clientTem = clientRepository.getClient(client.getIdClient());
            if (!clientTem.isEmpty()){
                if (client.getName() != null){
                    clientTem.get().setName(client.getName());
                }
                if (client.getEmail() != null){
                    clientTem.get().setEmail(client.getEmail());
                }
                if (client.getAge() != null){
                    clientTem.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    clientTem.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientTem.get());
            }else {
                return client;
            }
        }else {
            return client;
        }
    }

    public Boolean deleteClient(int client_id){
        Boolean success = clientRepository.getClient(client_id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;

    }
}