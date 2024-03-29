package com.budgetApp.crud.category;

import com.budgetApp.crud.AbstractCRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "2 - Categories")
@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractCRUDController<Category, Long, CategoryRepository> {


    public CategoryController(CategoryRepository repository) {
        super(repository);
    }
}
