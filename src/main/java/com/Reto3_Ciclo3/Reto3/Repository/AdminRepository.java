package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCRUDRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>)adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int admin_id){
        return adminCrudRepository.findById(admin_id);
    }

    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }

    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }
}