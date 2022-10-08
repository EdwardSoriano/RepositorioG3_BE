package com.Reto3_Ciclo3.Reto3.Repository;

import com.Reto3_Ciclo3.Reto3.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCRUDRepository categoryCRUDRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCRUDRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCRUDRepository.findById(id);
    }
    public Category save(Category category) {
        return categoryCRUDRepository.save(category);
    }
    public void deleteCategory(Category category){
        categoryCRUDRepository.delete(category);
    }
}