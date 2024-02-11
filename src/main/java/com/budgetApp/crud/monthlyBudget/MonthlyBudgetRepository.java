package com.budgetApp.crud.monthlyBudget;

import com.budgetApp.crud.category.Subcategory;
import com.budgetApp.crud.month.Month;
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
    List<MonthlySpendingBO> findAggregatedSpendingByMonth(Integer year, Integer month);

    @Query("""
            FROM MonthlyBudget mb
            JOIN FETCH mb.category as sc
            JOIN FETCH sc.parent as c
            LEFT JOIN FETCH mb.spendings
            WHERE mb.month = :month
            """)
    List<MonthlyBudget> findByMonth(Month month);

    MonthlyBudget findByMonthAndCategory(Month month, Subcategory subcategory);
}
