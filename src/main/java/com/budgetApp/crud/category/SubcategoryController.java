package com.budgetApp.crud.category;

import com.budgetApp.crud.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController extends AbstractCRUDController<Subcategory, Long, SubcategoryRepository> {

    public SubcategoryController(SubcategoryRepository repository) {
        super(repository);
    }
}
