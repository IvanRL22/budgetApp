package com.budgetApp.crud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public abstract class AbstractController<E, I, R extends CrudRepository<E, I>> {

    private final R repository;

    @GetMapping("/{id}")
    public E read(@PathVariable I id) {
        log.debug("Reading with ID {}", id);
        E entityRead = this.repository.findById(id).orElse(null);
        log.debug("Read category {}", entityRead != null ? entityRead : StringUtils.EMPTY);

        return entityRead;
    }
}
