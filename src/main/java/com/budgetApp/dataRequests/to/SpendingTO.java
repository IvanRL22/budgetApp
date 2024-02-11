package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.spending.Spending;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SpendingTO(
        @NotBlank(message = "Payee must be informed")
        String payee,
        @NotBlank(message = "Category must be informed")
        String categoryName,
        @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
        @Digits(integer=6, fraction=2)
        @NotNull(message = "Amount must be specified")
        BigDecimal amount,
        @NotNull(message = "Date must be specified")
        LocalDate date) {

    public static SpendingTO from(Spending po) {
        return new SpendingTO(po.getPayee(),
                po.getMonthlyBudget().getCategory().getName(),
                po.getAmount(),
                po.getDate());
    }
}
