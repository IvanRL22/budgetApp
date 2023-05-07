package com.budgetApp.crud.budget;

import com.budgetApp.crud.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")
public class BudgetController extends AbstractCRUDController<Budget, Integer, BudgetRepository> {
    public BudgetController(BudgetRepository repository) {
        super(repository);
    }
}
