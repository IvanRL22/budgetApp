package com.budgetApp.crud.category;

import com.budgetApp.crud.AbstractCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractCRUDController<Category, Integer, CategoryRepository> {


    public CategoryController(CategoryRepository repository) {
        super(repository);
    }
}
