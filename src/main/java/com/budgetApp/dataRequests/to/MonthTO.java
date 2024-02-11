package com.budgetApp.dataRequests.to;

import com.budgetApp.crud.month.Month;

public record MonthTO(Integer year, Integer month) {
    public static MonthTO from(Month monthPo) {
        return new MonthTO(monthPo.getYear(), monthPo.getMonth());
    }
}
