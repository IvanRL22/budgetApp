package com.budgetApp.crud;

import com.budgetApp.business.interfaces.Identifiable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractCRUDController<
        E extends Identifiable<ID>,
        ID,
        R extends CrudRepository<E, ID>> {

    private final R repository;

    @GetMapping("/{id}")
    public E read(@PathVariable ID id) {
        log.debug("Reading with ID {}", id);
        E readEntity = this.repository.findById(id).orElseThrow(AbstractCRUDController::create404NotFoundException);
        log.debug("Read {}", readEntity);

        return readEntity;
    }

    @PostMapping()
    public E create(@RequestBody E newEntity) {
        log.debug("Creating {}", newEntity);
        if (newEntity.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Creation requests may not contain an identifier");
        }
        E createdEntity = this.repository.save(newEntity);
        log.debug("Created {}", createdEntity);

        return createdEntity;
    }

    @PutMapping("/{id}")
    public E update(@PathVariable ID id,
                    @RequestBody E entity) {
        log.debug("Updating with ID {}", id);
        if (!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URI id does not match payload id");
        }
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

    @GetMapping("/all")
    public Iterable<E> getAll() {
        log.debug("Getting all entities");
        return this.repository.findAll();
    }

    private void checkIfEntityExists(ID identifier) {
        if (!this.repository.existsById(identifier)) {
            throw create404NotFoundException();
        }
    }

    private static ResponseStatusException create404NotFoundException() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested entity does not exist");
    }

}
