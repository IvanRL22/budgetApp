package com.budgetApp.crud.monthlyBudget;

import com.budgetApp.business.interfaces.Identifiable;
import com.budgetApp.crud.budget.Budget;
import com.budgetApp.crud.category.Subcategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MONTHLYBUDGET")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MonthlyBudget implements Identifiable<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BUDGET_ID")
    private Budget budget;

    @Embedded
    private Month month;

    @OneToOne(optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    @JsonIgnoreProperties("parent")
    private Subcategory category;

    @Column(name = "INITIAL_BALANCE")
    private int initialBalance;

    @Column(name = "AMOUNT")
    private int amount;
}
