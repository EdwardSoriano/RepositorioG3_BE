package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Model.Category;
import com.Reto3_Ciclo3.Reto3.Model.Client;
import com.Reto3_Ciclo3.Reto3.Services.CategoryServices;
import com.Reto3_Ciclo3.Reto3.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientServices.getAllClient();
    }
    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable("idClient")int idClient){
        return  clientServices.getClient(idClient);
    }

    @PostMapping("/save")
    public Client insertClient (@RequestBody Client client) {
        return clientServices.insertClient(client);
    }
    @PutMapping("/update")
    public Client updateCategory (@RequestBody Client Client){
        return  clientServices.updateClient(Client);
    }
}
