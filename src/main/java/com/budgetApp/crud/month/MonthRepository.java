package com.budgetApp.crud.month;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MonthRepository extends CrudRepository<Month, Long> {

    Optional<Month> getByYearAndMonth(Integer year, Integer month);
}
