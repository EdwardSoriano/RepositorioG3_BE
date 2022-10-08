package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Model.Admin;
import com.Reto3_Ciclo3.Reto3.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminServices adminServices;
   

    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminServices.getAllAdmin();
    }
    @GetMapping("/{idAdmin}")
    public Optional<Admin> getAdmin(@PathVariable("idAdmin")int idAdmin){
        return  AdminServices.getAdmin(idAdmin);
    }

    @PostMapping("/save")
    public Admin insertAdmin (@RequestBody AdminServices adminServices) {
        return adminServices.insertAdmin(admin);
    }
    @PutMapping("/update")
    public Admin updateAdmin (@RequestBody Admin admin){
        return  adminServices.updateAdmin(admin);
    }

}