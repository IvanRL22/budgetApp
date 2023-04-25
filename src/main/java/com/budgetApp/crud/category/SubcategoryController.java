package com.budgetApp.crud.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/subcategory")
@RequiredArgsConstructor
@Slf4j
public class SubcategoryController {

    private final SubcategoryRepository repository;

    @GetMapping("/{id}")
    public Subcategory read(@PathVariable Integer id) {
        log.debug("Reading category with ID {}", id);
        // TODO Handle entity not found
        Subcategory read = this.repository.findById(id).orElse(null);
        log.debug("Read category {}", read != null ? read : StringUtils.EMPTY);

        return read;
    }

    @PostMapping()
    public void create(@RequestBody Subcategory subcategory) {
        log.debug("Creating subcategory {}", subcategory);
        Subcategory created = this.repository.save(subcategory);
        log.debug("Created subcategory {}", created);

    }

    @PutMapping()
    public Subcategory update(@RequestBody Subcategory subcategory) {
        log.debug("Updating subcategory with ID {}", subcategory.getId());
        if (!this.repository.existsById(subcategory.getId())) {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        Subcategory updated = this.repository.save(subcategory);
        log.debug("Updated subcategory successfully");

        return updated;
    }

    @DeleteMapping()
    public void delete(@RequestBody Subcategory category) {
        log.debug("Deleting category {}", category);
        this.repository.delete(category);
        log.debug("Deleted category successfully");
    }
}
