package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Model.Message;
import com.Reto3_Ciclo3.Reto3.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageServices messageServices;

    @GetMapping("/all")
    public List<Message> getAll() {
        return messageServices.getAllMessage();
    }
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("idMessage")int idMessage){
        return  messageServices.getMessage(idMessage);
    }

    @PostMapping("/save")
    public Message insertMessage (@RequestBody Message message) {
        return messageServices.insertMessage(message);
    }
    @PutMapping("/update")
    public Message updateCategory (@RequestBody Message message){
        return  messageServices.updateMessage(message);
    }
}
