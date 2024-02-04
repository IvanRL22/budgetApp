package com.budgetApp.crud.category;

import com.budgetApp.crud.AbstractCRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "2.1 - Subcategories")
@RestController
@RequestMapping("/subcategory")
public class SubcategoryController extends AbstractCRUDController<Subcategory, Long, SubcategoryRepository> {

    public SubcategoryController(SubcategoryRepository repository) {
        super(repository);
    }
}
