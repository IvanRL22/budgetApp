package com.budgetApp.crud.monthlyBudget;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonthlyBudgetRepository extends CrudRepository<MonthlyBudget, Long> {

    List<MonthlyBudget> findAllByBudgetIdAndMonth(Long budgetId, Month month);
}
