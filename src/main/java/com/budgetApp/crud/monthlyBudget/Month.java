package com.budgetApp.crud.monthlyBudget;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Embeddable
@Getter
@Setter
public class Month {

    @Column(name = "YEAR", nullable = false)
    @Range(min = 2020, max = 9999)
    private Integer year;

    @Column(name = "MONTH", nullable = false)
    @Range(min = 1, max = 12)
    private Integer month;
}
