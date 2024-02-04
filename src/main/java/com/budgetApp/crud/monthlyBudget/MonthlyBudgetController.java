package com.budgetApp.crud.monthlyBudget;

import com.budgetApp.crud.AbstractCRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "3 - Monthly budget")
@RestController
@RequestMapping("/monthlyBudget")
public class MonthlyBudgetController extends AbstractCRUDController<MonthlyBudget, Long, MonthlyBudgetRepository> {
    public MonthlyBudgetController(MonthlyBudgetRepository repository) {
        super(repository);
    }
}
