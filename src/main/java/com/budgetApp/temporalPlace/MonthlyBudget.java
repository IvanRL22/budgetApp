package com.budgetApp.temporalPlace;

import com.budgetApp.crud.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class MonthlyBudget {

    @Embedded
    private Month month;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CATEGORY")
    @JsonIgnoreProperties("children")
    private Category category;

    @Column(name = "AMOUNT", nullable = false)
    @Range(min = 0)
    private Double amount;

    @Column(name = "BALANCE", nullable = false)
    private Double balance;
}
