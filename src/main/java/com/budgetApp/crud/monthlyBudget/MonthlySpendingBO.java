package com.budgetApp.crud.monthlyBudget;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthlySpendingBO {

    private String category;
    private BigDecimal amount;
}
