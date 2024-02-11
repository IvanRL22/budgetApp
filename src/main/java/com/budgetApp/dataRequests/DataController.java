package com.budgetApp.dataRequests;

import com.budgetApp.crud.category.CategoryRepository;
import com.budgetApp.dataRequests.to.CategoryTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;
import java.util.List;

@Tag(name = "5 - Data")
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final CategoryRepository categoryRepository;


    @GetMapping("/subcategories")
    public List<CategoryTO> getCategories() {
        return StreamSupport.stream(this.categoryRepository.findAll().spliterator(), false)
                .map(CategoryTO::from)
                .toList();
    }
}
