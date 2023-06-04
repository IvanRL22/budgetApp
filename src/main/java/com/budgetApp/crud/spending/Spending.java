package com.budgetApp.crud.spending;

import com.budgetApp.business.interfaces.Identifiable;
import com.budgetApp.crud.monthlyBudget.MonthlyBudget;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity(name = "SPENDINGS")
@NoArgsConstructor(force = true)
@Getter
@Setter
@ToString
public class Spending implements Identifiable<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MONTHLYBUDGET_ID")
    private MonthlyBudget monthlyBudget;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "PAYEE")
    @Length(max = 50)
    private String payee;

    @Column(name = "SPENDING_DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate date;
}
