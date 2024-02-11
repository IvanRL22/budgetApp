package com.budgetApp.crud.spending;

import com.budgetApp.business.interfaces.Identifiable;
import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SPENDINGS")
@NoArgsConstructor(force = true)
@Getter
@Setter
@ToString
public class Spending implements Identifiable<Long> {

    public Spending(MonthlyBudget monthlyBudget, BigDecimal amount, String payee, LocalDate date) {
        this.monthlyBudget = monthlyBudget;
        this.amount = amount;
        this.payee = payee;
        this.date = date;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MONTHLY_BUDGET_ID")
    private MonthlyBudget monthlyBudget;

    @Range(min = 0)
    @Column(name = "AMOUNT", precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "PAYEE")
    @Length(max = 50)
    private String payee;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate date;

}
