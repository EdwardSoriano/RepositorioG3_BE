package com.Reto3_Ciclo3.Reto3.Services;


import com.Reto3_Ciclo3.Reto3.Model.Message;
import com.Reto3_Ciclo3.Reto3.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class MessageServices {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public Message insertMessage(Message message) {
        if (message.getIdMessage() == null) {
            if (message.getIdMessage() != null) {   //solicita campos obligatorios
                return messageRepository.save(message);
            } else
                return message;

        }

        return message;
    }


    public Message updateMessage(Message message){
        if (message.getIdMessage() != null) {
            Optional<Message> temp = messageRepository.getMessage(message.getIdMessage());
            if (!temp.isEmpty()){
                if (message.getMessagetext() != null)
                    temp.get().setMessagetext(message.getMessagetext());

                return messageRepository.save(temp.get());
            }
            else
                return message;

        }
        else
            return message;
    }




    public boolean deleteMessage(int idMessage) {
        boolean success = false;
        Optional<Message> temp=messageRepository.getMessage(idMessage);
        if (temp.isEmpty()){
            success= true;
        }
        return success;
    }


}


