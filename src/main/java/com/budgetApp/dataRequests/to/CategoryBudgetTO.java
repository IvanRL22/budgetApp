package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBudgetTO implements Comparable<CategoryBudgetTO>{

    private String category;
    private BigDecimal amount;
    private BigDecimal balance;

    public static CategoryBudgetTO from(MonthlyBudget monthlyBudget) {
        return new CategoryBudgetTO(monthlyBudget.getCategory().getName(),
                monthlyBudget.getAmount(),
                monthlyBudget.getBalance());
    }

    @Override
    public int compareTo(CategoryBudgetTO c) {
        return this.amount.compareTo(c.getAmount());
    }
}
