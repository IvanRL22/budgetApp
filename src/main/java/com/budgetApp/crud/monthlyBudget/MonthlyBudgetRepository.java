package com.budgetApp.crud.monthlyBudget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonthlyBudgetRepository extends CrudRepository<MonthlyBudget, Long> {

    @Query("""
            SELECT new com.budgetApp.crud.monthlyBudget.MonthlySpendingBO(c.name, sum(s.amount))
            FROM Spending s
            JOIN s.monthlyBudget as mb
            JOIN mb.category as c
            JOIN mb.month as m
            WHERE m.year = :year
            AND m.month = :month
            GROUP BY c.name
            """)
    List<MonthlySpendingBO> findByMonth(Integer year, Integer month);

}
