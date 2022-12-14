package com.Reto3_Ciclo3.Reto3.Service;

import com.Reto3_Ciclo3.Reto3.Models.Ortopedic;
import com.Reto3_Ciclo3.Reto3.Repository.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {
    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAllOrtopedic(){
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int ortopedic_id){
        return ortopedicRepository.getOrtopedic(ortopedic_id);
    }

    public Ortopedic insertOrtopedic(Ortopedic ortopedic){
        return ortopedicRepository.save(ortopedic);
    }

    public Ortopedic upstaeOrtopedic(Ortopedic ortopedic){
        if (ortopedic.getId() != null){
            Optional<Ortopedic> ortopedicTem = ortopedicRepository.getOrtopedic(ortopedic.getId());
            if (!ortopedicTem.isEmpty()){
                if (ortopedic.getName() != null){
                    ortopedicTem.get().setName(ortopedic.getName());
                }
                if (ortopedic.getBrand() != null){
                    ortopedicTem.get().setBrand(ortopedic.getBrand());
                }
                if (ortopedic.getYear() != null){
                    ortopedicTem.get().setYear(ortopedic.getYear());
                }
                if (ortopedic.getDescription() != null){
                    ortopedicTem.get().setDescription(ortopedic.getDescription());
                }
                return ortopedicRepository.save(ortopedicTem.get());
            }else {
                return ortopedic;
            }
        }else {
            return ortopedic;
        }
    }

    public Boolean deleteOrtopedic(int ortopedic_id){
        Boolean success = ortopedicRepository.getOrtopedic(ortopedic_id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return success;
    }
}