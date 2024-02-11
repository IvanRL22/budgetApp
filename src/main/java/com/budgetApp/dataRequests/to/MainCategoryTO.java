package com.budgetApp.dataRequests.to;

import java.math.BigDecimal;
import java.util.List;

public record MainCategoryTO(String name, List<CategoryBudgetTO> budgets, BigDecimal amount, BigDecimal balance) {

    public static MainCategoryTO from(String categoryName, List<CategoryBudgetTO> budgets) {
        return new MainCategoryTO(categoryName,
                budgets,
                budgets.stream().map(CategoryBudgetTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add),
                budgets.stream().map(CategoryBudgetTO::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
