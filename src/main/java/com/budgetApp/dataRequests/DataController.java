package com.budgetApp.dataRequests;

import com.budgetApp.crud.category.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;
import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final SubcategoryRepository subcategoryRepository;


    @GetMapping("/subcategories")
    public List<CategoryTO> getCategories() {
        return StreamSupport.stream(this.subcategoryRepository.findAll().spliterator(), false)
                .map(s -> new CategoryTO(s.getId(), s.getName()))
                .toList();
    }

}

record CategoryTO(Long id, String name) {}
