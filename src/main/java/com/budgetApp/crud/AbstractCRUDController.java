package com.budgetApp.crud;

import com.budgetApp.business.interfaces.Identifiable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractCRUDController<E extends Identifiable<ID>, ID, R extends CrudRepository<E, ID>> {

    private final R repository;

    @GetMapping("/{id}")
    public E read(@PathVariable ID id) {
        log.debug("Reading with ID {}", id);
        E readEntity = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        log.debug("Read {}", readEntity != null ? readEntity : StringUtils.EMPTY);

        return readEntity;
    }

    @PostMapping()
    public E create(@RequestBody E newEntity) {
        log.debug("Creating category {}", newEntity);
        checkIfEntityExists(newEntity.getId());
        E createdEntity = this.repository.save(newEntity);
        log.debug("Created category {}", createdEntity);

        return createdEntity;
    }

    @PutMapping()
    public E update(@RequestBody E entity) {
        log.debug("Updating with ID {}", entity.getId());
        checkIfEntityExists(entity.getId());
        E updatedEntity = this.repository.save(entity);
        log.debug("Updated successfully: {}", updatedEntity);

        return updatedEntity;
    }

    @DeleteMapping()
    public void delete(@RequestBody E entity) {
        log.debug("Deleting {}", entity);
        checkIfEntityExists(entity.getId());
        this.repository.delete(entity);
        log.debug("Deleted successfully");
    }

    private void checkIfEntityExists(ID identifier) {
        if (!this.repository.existsById(identifier)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
