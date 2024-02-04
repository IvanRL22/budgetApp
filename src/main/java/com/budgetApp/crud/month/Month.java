package com.budgetApp.crud.month;

import com.budgetApp.business.interfaces.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(
        name = "MONTHS",
        uniqueConstraints = @UniqueConstraint(name = "UC_MONTHS_YEAR_MONTH", columnNames = {"YEAR", "MONTH"}))
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Month implements Identifiable<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "YEAR", nullable = false, updatable = false)
    @Range(min = 2020, max = 9999)
    private Integer year;

    @Column(name = "MONTH", nullable = false, updatable = false)
    @Range(min = 1, max = 12)
    private Integer month;

    @Column(name = "NOTES")
    private String notes;

//    @OneToMany(mappedBy = "month")
//    private Set<MonthlyBudget> budgets;
}
