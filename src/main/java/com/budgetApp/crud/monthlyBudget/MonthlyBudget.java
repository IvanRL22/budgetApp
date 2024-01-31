package com.budgetApp.crud.monthlyBudget;

import com.budgetApp.business.interfaces.Identifiable;
import com.budgetApp.crud.category.Subcategory;
import com.budgetApp.crud.spending.Spending;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

    @Embedded
    private Month month;

    @OneToOne(optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    @JsonIgnoreProperties("parent")
    private Subcategory category;

    @Column(name = "INITIAL_BALANCE", precision = 8, scale = 2)
    private BigDecimal initialBalance;

    @Range(min = 0)
    @Column(name = "AMOUNT", precision = 8, scale = 2)
    private BigDecimal amount;

    @OneToMany(mappedBy = "monthlyBudget", orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private Set<Spending> spendings = new HashSet<>();

    @JsonIgnore
    public float getBalance() {
        return amount.add(initialBalance).add(getTotalSpendings()).floatValue();
    }
    private BigDecimal getTotalSpendings() {
        return spendings.stream()
                .map(Spending::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::subtract);
    }
}
