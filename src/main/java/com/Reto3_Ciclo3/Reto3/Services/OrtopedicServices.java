package com.Reto3_Ciclo3.Reto3.Services;

import com.Reto3_Ciclo3.Reto3.Model.Category;

import com.Reto3_Ciclo3.Reto3.Model.Ortopedic;
import com.Reto3_Ciclo3.Reto3.Repository.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicServices {

        @Autowired
        private OrtopedicRepository ortopedicRepository;

        public List<Ortopedic> getAllOrtopedic() {
            return ortopedicRepository.getAll();
        }

        public Optional<Ortopedic>getOrtopedic(int id) {
            return ortopedicRepository.getOrtopedic(id);
        }

        public Ortopedic insertCategory(Ortopedic ortopedic) {
            if (ortopedic.getId() == null) {
                if (ortopedic.getName() != null &&
                        ortopedic.getBrand() != null &&
                        ortopedic.getYear() != null&&
                        ortopedic.getDescription() != null) {   //solicita campos obligatorios
                    return ortopedicRepository.save(ortopedic);
                } else
                    return ortopedic;
            }
            return ortopedic;
        }

    public Ortopedic insertOropedic(Ortopedic ortopedic){
        if(ortopedic.getId()==null){
            return ortopedicRepository.save(ortopedic);
        }else{
            Optional<Ortopedic> temp = ortopedicRepository.getOrtopedic(ortopedic.getId());

            if(temp.isEmpty()){
                return ortopedic;
            }else{
                return ortopedicRepository.save(ortopedic);
            }

        }
    }
        public Ortopedic updateCategory(Ortopedic ortopedic){
            if (ortopedic.getId() != null) {
                Optional<Ortopedic> temp = ortopedicRepository.getOrtopedic(ortopedic.getId());
                if (temp.isEmpty()){
                    if (ortopedic.getName() != null)
                        temp.get().setName(ortopedic.getName());
                    if (ortopedic.getBrand() != null)
                        temp.get().setBrand(ortopedic.getBrand());
                    if (ortopedic.getYear() != null)
                        temp.get().setYear(ortopedic.getYear());
                    if (ortopedic.getDescription() !=null) {
                        temp.get().setDescription(ortopedic.getDescription());
                    }
                    ortopedicRepository.save(temp.get());
                    return temp.get();
                }
                else
                    return ortopedic;

            }
            else
                return ortopedic;
        }




        public boolean deleteOrtopedic(int id) {
            boolean success = false;
            Optional<Ortopedic> temp=ortopedicRepository.getOrtopedic(id);
            if (temp.isEmpty()){
                success= true;
            }
            return success;
        }

    }
