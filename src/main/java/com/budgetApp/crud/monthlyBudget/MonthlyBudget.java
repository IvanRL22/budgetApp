package com.budgetApp.crud.monthlyBudget;

import com.budgetApp.crud.category.Subcategory;
import com.budgetApp.temporalPlace.Month;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class MonthlyBudget {

    // TODO: commented until Budget CRUD is created
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "BUDGET_ID")
//    private Budget budget;
    @Embedded
    private Month month;
    @OneToOne(optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    private Subcategory category;
    private int initialBalance;
    private int amount;
}
