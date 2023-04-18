package com.budgetApp.application.crud.category;

import org.springframework.web.bind.annotation.*;

/**
 * Still on development
 * TODO: create service / convert to crud repository
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Category read(@PathVariable Integer id) {
        // TODO Handle entity not found
        return this.repository.findById(id).orElse(null);
    }

    @PostMapping()
    public Category create(@RequestBody Category newCategory) {
        return this.repository.save(newCategory);
    }

    @PutMapping()
    public Category update(@RequestBody Category category) {
        return this.repository.save(category);
    }

    @DeleteMapping()
    public void delete(@RequestBody Category category) {
        this.repository.delete(category);
    }

}
