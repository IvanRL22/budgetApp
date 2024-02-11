package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.category.Category;
import com.budgetApp.crud.category.Subcategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

public record CategoryTO(Long id, String name, @JsonInclude(Include.NON_NULL) List<CategoryTO> children) {
    public static CategoryTO from(Category po) {
        return new CategoryTO(po.getId(), po.getName(),
                po.getChildren().stream().map(CategoryTO::from).toList());
    }
    public static CategoryTO from(Subcategory po) {
        return new CategoryTO(po.getId(), po.getName(), null);
    }
}
