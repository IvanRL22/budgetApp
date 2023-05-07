package com.budgetApp.crud.monthlyBudget;

import com.budgetApp.crud.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monthlyBudget")
public class MonthlyBudgetController extends AbstractCRUDController<MonthlyBudget, Long, MonthlyBudgetRepository> {
    public MonthlyBudgetController(MonthlyBudgetRepository repository) {
        super(repository);
    }
}
