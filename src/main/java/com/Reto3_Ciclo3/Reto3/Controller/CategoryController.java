package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Model.Category;
import com.Reto3_Ciclo3.Reto3.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryServices.getAllCategory();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return  categoryServices.getCategory(id);
    }

    @PostMapping("/save")
    public Category insertCategory (@RequestBody Category category) {
         return categoryServices.insertCategory(category);
    }
    @PutMapping("/update")
    public Category updateCategory (@RequestBody Category category){
        return  categoryServices.updateCategory(category);
    }

}
