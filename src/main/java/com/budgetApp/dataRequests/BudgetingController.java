package com.budgetApp.dataRequests;

import com.budgetApp.crud.monthlyBudget.MonthlyBudgetRepository;
import com.budgetApp.crud.monthlyBudget.MonthlySpendingBO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "4 - Budgeting")
@RestController
@RequestMapping("/budgeting")
@RequiredArgsConstructor
@Slf4j
public class BudgetingController {

    private final MonthlyBudgetRepository budgetingRepository;

    @GetMapping("/spendings/{year}/{month}")
    public List<MonthlySpendingBO> getMonthSpendings(@PathVariable Integer year,
                                                     @PathVariable Integer month) {

        return budgetingRepository.findByMonth(year, month);
    }

}
