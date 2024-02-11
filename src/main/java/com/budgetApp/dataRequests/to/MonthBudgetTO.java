package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.month.Month;
import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthBudgetTO {

    private MonthTO month;
    private List<MainCategoryTO> categories;
    private BigDecimal totalBudget;

    public static MonthBudgetTO from(Month monthPo, List<MonthlyBudget> byMonth) {
        List<MainCategoryTO> result = new ArrayList<>();
        byMonth.stream()
                .collect(groupingBy(mb -> mb.getCategory().getParent()))
                .forEach((k, v) -> result.add(MainCategoryTO.from(k.getName(),v.stream().map(CategoryBudgetTO::from).toList())));

        var total = result.stream()
                .flatMap(mc -> mc.budgets().stream())
                .map(CategoryBudgetTO::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new MonthBudgetTO(MonthTO.from(monthPo), result, total);
    }
}