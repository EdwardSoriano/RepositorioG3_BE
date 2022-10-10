package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Models.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrtopedicRepository {
    @Autowired
    private OrtopedicCRUDRepository ortopedicCrudRepository;

    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicCrudRepository.findAll();
    }

    public Optional<Ortopedic> getOrtopedic(int ortopedic_id){
        return ortopedicCrudRepository.findById(ortopedic_id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        return ortopedicCrudRepository.save(ortopedic);
    }

    public void delete(Ortopedic ortopedic){
        ortopedicCrudRepository.delete(ortopedic);
    }

}