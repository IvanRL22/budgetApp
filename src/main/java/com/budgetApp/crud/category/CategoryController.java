package com.budgetApp.crud.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Still on development
 * TODO: create service / convert to crud repository
 */
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryRepository repository;


    @GetMapping("/{id}")
    public Category read(@PathVariable Integer id) {
        log.debug("Reading category with ID {}", id);
        // TODO Handle entity not found
        Category read = this.repository.findById(id).orElse(null);
        log.debug("Read category {}", read != null ? read : StringUtils.EMPTY);

        return read;
    }

    @PostMapping()
    public Category create(@RequestBody Category newCategory) {
        log.debug("Creating category {}", newCategory);
        Category created = this.repository.save(newCategory);
        log.debug("Created category {}", created);

        return created;
    }

    @PutMapping()
    public Category update(@RequestBody Category category) {
        log.debug("Updating category with ID {}", category.getId());
        Category updated = this.repository.save(category);
        log.debug("Updated category successfully");

        return updated;
    }

    @DeleteMapping()
    public void delete(@RequestBody Category category) {
        log.debug("Deleting category {}", category);
        this.repository.delete(category);
        log.debug("Deleted category successfully");
    }



}
