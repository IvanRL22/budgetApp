package com.budgetApp.crud.income;

import com.budgetApp.business.interfaces.Identifiable;
import com.budgetApp.crud.month.Month;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "INCOMES")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Income implements Identifiable<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @Column(name = "PAYER", length = 50)
    private String payer;

    @ManyToOne
    @JoinColumn(name = "MONTH_ID")
    private Month month;

    @Range(min = 0)
    @Column(name = "AMOUNT", precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate date;


}
