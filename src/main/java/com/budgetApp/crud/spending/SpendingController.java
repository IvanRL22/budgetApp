package com.budgetApp.crud.spending;

import com.budgetApp.crud.AbstractCRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "3.2 - Spending")
@RestController
@RequestMapping("/spending")
public class SpendingController extends AbstractCRUDController<Spending, Long, SpendingRepository> {
    public SpendingController(SpendingRepository repository) {
        super(repository);
    }
}
