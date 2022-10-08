package com.Reto3_Ciclo3.Reto3.Services;

import com.Reto3_Ciclo3.Reto3.Model.Category;
import com.Reto3_Ciclo3.Reto3.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category insertCategory(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> temp = categoryRepository.getCategory(category.getId());

            if(temp.isEmpty()){
                return category;
            }else{
                return categoryRepository.save(category);
            }

        }
    }

    public Category updateCategory(Category category){
            if (category.getId() != null) {
                Optional<Category> temp = categoryRepository.getCategory(category.getId());
                if (temp.isEmpty()){
                    if (category.getName() != null)
                        temp.get().setName(category.getName());
                    if (category.getDescription() !=null) {
                        temp.get().setDescription(category.getDescription());
                    }
                    categoryRepository.save(temp.get());
                    return temp.get();
                }
                else
                    return category;

            }
            else
                return category;
    }




    public boolean deleteCategory(int id) {
        boolean success = false;
        Optional<Category> temp=categoryRepository.getCategory(id);
            if (temp.isEmpty()){
                success= true;
            }
            return success;
    }


}
