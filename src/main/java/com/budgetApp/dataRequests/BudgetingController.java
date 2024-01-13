package com.budgetApp.dataRequests;

import com.budgetApp.crud.monthlyBudget.Month;
import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import com.budgetApp.crud.monthlyBudget.MonthlyBudgetRepository;
import com.budgetApp.dataRequests.to.CategoryBudgetTO;
import com.budgetApp.dataRequests.to.MonthBudgetTO;
import com.budgetApp.dataRequests.to.MonthTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/budgeting")
@RequiredArgsConstructor
@Slf4j
public class BudgetingController {

    private final MonthlyBudgetRepository budgetingRepository;

    @GetMapping("/{budgetId}/{year}/{month}")
    public MonthBudgetTO getMonthBudget(@RequestParam Long budgetId,
                                        @RequestParam Integer year,
                                        @RequestParam Integer month) {

        Month monthPO = new Month(year, month);
        List<MonthlyBudget> results = budgetingRepository.findAllByBudgetIdAndMonth(budgetId, monthPO);

        return new MonthBudgetTO(new MonthTO(year, month),
                results.stream()
                        .map(CategoryBudgetTO::from)
                        .sorted(Comparator.comparing(CategoryBudgetTO::getCategory))
                        .toList());
    }

}
