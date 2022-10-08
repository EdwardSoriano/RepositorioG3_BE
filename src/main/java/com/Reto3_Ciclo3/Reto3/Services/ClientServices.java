package com.Reto3_Ciclo3.Reto3.Services;

import com.Reto3_Ciclo3.Reto3.Model.Category;
import com.Reto3_Ciclo3.Reto3.Model.Client;
import com.Reto3_Ciclo3.Reto3.Repository.CategoryRepository;
import com.Reto3_Ciclo3.Reto3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient) {
        return clientRepository.getClient(idClient);
    }

    public Client insertClient(Client client) {
        if (client.getIdClient() == null) {
            if (client.getEmail() != null &&
                    client.getPassword() != null &&
                    client.getName() != null &&
                    client.getAge() != null) {   //solicita campos obligatorios
                return clientRepository.save(client);
            } else
                return client;

        }

        return client;
    }


    public Client updateClient(Client client){
        if (client.getIdClient() != null) {
            Optional<Client> temp = clientRepository.getClient(client.getIdClient());
            if (!temp.isEmpty()){
                if (client.getEmail() != null)
                    temp.get().setEmail(client.getEmail());
                if (client.getPassword() !=null)
                    temp.get().setPassword(client.getPassword());
                if (client.getName() !=null)
                    temp.get().setName(client.getName());
                if (client.getAge() !=null)
                    temp.get().setAge(client.getAge());
                return clientRepository.save(temp.get());
            }
            else
                return client;

        }
        else
            return client;
    }




    public boolean deleteClient(int idCliente) {
        boolean success = false;
        Optional<Client> temp=clientRepository.getClient(idCliente);
        if (temp.isEmpty()){
            success= true;
        }
        return success;
    }

}
