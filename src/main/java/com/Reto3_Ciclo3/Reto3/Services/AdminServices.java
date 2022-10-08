package com.Reto3_Ciclo3.Reto3.Services;



import com.Reto3_Ciclo3.Reto3.Model.Admin;
import com.Reto3_Ciclo3.Reto3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


    @Service
    public class AdminServices {
        @Autowired
        private AdminRepository adminRepository;

        public List<Admin> getAllAdmin() {
            return AdminRepository.getAll();
        }

        public static Optional<Admin> getAdmin(int idAdmin) {
            return AdminRepository.getAdmin(idAdmin);
        }

        public Admin insertAdmin(Admin admin) {
            if (admin.getIdAdmin() == null) {
                return AdminRepository.save(admin);
            } else {
                Optional<Admin> temp = AdminRepository.getAdmin(admin.getIdAdmin());

                if (temp.isEmpty()) {
                    return admin;
                } else {
                    return AdminRepository.save(admin);
                }

            }
        }

        public Admin updateAdmin(Admin admin) {
            if (admin.getIdAdmin() != null) {
                Optional<Admin> temp = AdminRepository.getAdmin(admin.getIdAdmin());
                if (temp.isEmpty()) {
                    if (admin.getName() != null)
                        temp.get().setName(admin.getName());
                    if (admin.getPassword() != null) {
                        temp.get().setPassword(admin.getPassword());
                    }
                    adminRepository.save(temp.get());
                    return temp.get();
                } else
                    return admin;

            } else
                return admin;
        }


        public boolean deleteAdmin(int idAdmin) {
            boolean success = false;
            Optional<Admin> temp = adminRepository.getAdmin(idAdmin);
            if (temp.isEmpty()) {
                success = true;
            }
            return success;
        }
    }
