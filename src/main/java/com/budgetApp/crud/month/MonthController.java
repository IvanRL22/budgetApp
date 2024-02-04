package com.budgetApp.crud.month;

import com.budgetApp.crud.AbstractCRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "1 - Months")
@RestController
@RequestMapping("/month")
public class MonthController extends AbstractCRUDController<Month, Long, MonthRepository> {
    public MonthController(MonthRepository repository) {
        super(repository);
    }
}
