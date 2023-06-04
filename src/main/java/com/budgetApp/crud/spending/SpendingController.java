package com.budgetApp.crud.spending;

import com.budgetApp.crud.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spending")
public class SpendingController extends AbstractCRUDController<Spending, Long, SpendingRepository> {
    public SpendingController(SpendingRepository repository) {
        super(repository);
    }
}
