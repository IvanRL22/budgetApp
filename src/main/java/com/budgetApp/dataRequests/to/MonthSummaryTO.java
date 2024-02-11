package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.monthlyBudget.MonthlySpendingBO;

import java.math.BigDecimal;
import java.util.List;

public record MonthSummaryTO(List<MonthlySpendingBO> spendings, BigDecimal totalSpent) {
    public static MonthSummaryTO from(List<MonthlySpendingBO> monthSpendings) {
        return new MonthSummaryTO(monthSpendings,
                monthSpendings.stream()
                        .map(MonthlySpendingBO::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

}
