package com.budgetApp.crud.month;

import com.budgetApp.crud.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthController extends AbstractCRUDController<Month, Long, MonthRepository> {
    public MonthController(MonthRepository repository) {
        super(repository);
    }
}
