package com.Reto3_Ciclo3.Reto3.Controller;

import com.Reto3_Ciclo3.Reto3.Models.Category;
import com.Reto3_Ciclo3.Reto3.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/Category")
public class CategoryContoller {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category category){
        return  categoryService.insertCategory(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCategory(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}