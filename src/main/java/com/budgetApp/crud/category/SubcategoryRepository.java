package com.budgetApp.crud.category;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {

    Optional<Subcategory> getByName(String name);
}
