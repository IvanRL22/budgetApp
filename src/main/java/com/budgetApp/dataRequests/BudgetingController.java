package com.budgetApp.dataRequests;

import com.budgetApp.crud.category.Subcategory;
import com.budgetApp.crud.category.SubcategoryRepository;
import com.budgetApp.crud.month.Month;
import com.budgetApp.crud.month.MonthRepository;
import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import com.budgetApp.crud.monthlyBudget.MonthlyBudgetRepository;
import com.budgetApp.crud.spending.Spending;
import com.budgetApp.crud.spending.SpendingRepository;
import com.budgetApp.dataRequests.to.MonthBudgetTO;
import com.budgetApp.dataRequests.to.MonthSummaryTO;
import com.budgetApp.dataRequests.to.SpendingTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Tag(name = "4 - Budgeting")
@RestController
@RequestMapping("/budgeting")
@RequiredArgsConstructor
@Slf4j
public class BudgetingController {

    private final MonthlyBudgetRepository budgetingRepository;
    private final MonthRepository monthRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final SpendingRepository spendingRepository;


    @Operation(summary = "Gets aggregated month expenses by category")
    @GetMapping("/spendings/{year}/{month}")
    public MonthSummaryTO getMonthSpendings(@PathVariable Integer year,
                                                     @PathVariable Integer month) {

        return MonthSummaryTO.from(budgetingRepository.findAggregatedSpendingByMonth(year, month));
    }

    @Operation(summary = "Gets month budget details")
    @GetMapping("/{year}/{month}")
    public MonthBudgetTO getMonthBudget(@PathVariable Integer year,
                                        @PathVariable Integer month) {

        var monthPo = monthRepository.getByYearAndMonth(year, month)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "The is no budget for month %d/%d".formatted(year, month)));

        return MonthBudgetTO.from(monthPo, budgetingRepository.findByMonth(monthPo));
    }

    @PostMapping("/add/spending")
    public SpendingTO addSpending(@RequestBody @Valid SpendingTO newSpending) {
        Month month = monthRepository.getByYearAndMonth(newSpending.date().getYear(), newSpending.date().getMonthValue())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "The is no budget for month %d/%d".formatted(newSpending.date().getMonthValue(), newSpending.date().getYear())));

        Subcategory category = subcategoryRepository.getByName(newSpending.categoryName())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "The category %s does not exist".formatted(newSpending.categoryName())));

        MonthlyBudget budget = budgetingRepository.findByMonthAndCategory(month, category);

        return SpendingTO.from(spendingRepository.save(new Spending(budget,
                newSpending.amount(),
                newSpending.payee(),
                newSpending.date())));
    }

    @Operation(summary = "Updates a particular budget's amount")
    @PatchMapping("/{year}/{month}/{categoryName}")
    public void setBudgetAmount(
            @PathVariable
            Integer year,
            @PathVariable
            Integer month,
            @PathVariable
            String categoryName,
            @RequestParam
            @Digits(integer = 6, fraction = 2)
            @DecimalMin(value = "0.0")
            @NotNull
            BigDecimal amount) {

        Month monthPo = monthRepository.getByYearAndMonth(year, month)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "The is no budget for month %d/%d".formatted(year, month)));

        Subcategory category = subcategoryRepository.getByName(categoryName)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "The category %s does not exist".formatted(categoryName)));

        MonthlyBudget budget = budgetingRepository.findByMonthAndCategory(monthPo, category);
        budget.setAmount(amount);
        budgetingRepository.save(budget);
    }

}
