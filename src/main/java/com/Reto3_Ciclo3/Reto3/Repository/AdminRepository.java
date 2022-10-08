package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCRUDRepository adminCRUDRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminCRUDRepository.findAll();
    }

    public Optional<Admin> getAdmin(int idAdmin) {
        return adminCRUDRepository.findById(idAdmin);
    }
    public Admin save(Admin admin) {
        return adminCRUDRepository.save(admin);
    }
    public void deleteAdmin(Admin admin){
        adminCRUDRepository.delete(admin);
    }
}
