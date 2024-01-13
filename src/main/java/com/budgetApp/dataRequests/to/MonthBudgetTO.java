package com.budgetApp.dataRequests.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthBudgetTO {

    private MonthTO month;
    private List<CategoryBudgetTO> categories;

}