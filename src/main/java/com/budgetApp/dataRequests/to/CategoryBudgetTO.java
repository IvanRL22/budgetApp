package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBudgetTO {

    private String category;
    private float amount;
    private float balance;

    public static CategoryBudgetTO from(MonthlyBudget monthlyBudget) {
        CategoryBudgetTO category = new CategoryBudgetTO();
        category.setCategory(monthlyBudget.getCategory().getName());
        category.setAmount(monthlyBudget.getAmount().floatValue());
        category.setBalance(monthlyBudget.getBalance());

        return category;
    }
}
