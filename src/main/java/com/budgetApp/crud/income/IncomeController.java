package com.budgetApp.crud.income;

import com.budgetApp.crud.AbstractCRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "3.1 - Income")
@RestController
@RequestMapping("/income")
public class IncomeController extends AbstractCRUDController<Income, Long, IncomeRepository> {
    public IncomeController(IncomeRepository repository) {
        super(repository);
    }
}
