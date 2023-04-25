package com.budgetApp.crud;

import com.budgetApp.business.interfaces.Identifiable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractCRUDController<E extends Identifiable, ID, R extends CrudRepository<E, ID>> {

    private final R repository;

    @GetMapping("/{id}")
    public E read(@PathVariable ID id) {
        log.debug("Reading with ID {}", id);
        // TODO Handle entity not found
        E readEntity = this.repository.findById(id).orElse(null);
        log.debug("Read {}", readEntity != null ? readEntity : StringUtils.EMPTY);

        return readEntity;
    }

    @PostMapping()
    public E create(@RequestBody E newEntity) {
        log.debug("Creating category {}", newEntity);
        E createdEntity = this.repository.save(newEntity);
        log.debug("Created category {}", createdEntity);

        return createdEntity;
    }

    @PutMapping()
    public E update(@RequestBody E category) {
        log.debug("Updating with ID {}", category.getId());
        E updatedEntity = this.repository.save(category);
        log.debug("Updated successfully: {}", updatedEntity);

        return updatedEntity;
    }

    @DeleteMapping()
    public void delete(@RequestBody E category) {
        log.debug("Deleting {}", category);
        this.repository.delete(category);
        log.debug("Deleted successfully");
    }
}
