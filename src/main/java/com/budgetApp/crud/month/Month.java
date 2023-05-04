package com.budgetApp.crud.month;

import com.budgetApp.business.interfaces.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Entity(name = "MONTHS")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Month implements Comparable<Month>, Identifiable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "YEAR", nullable = false)
    @Range(min = 2020, max = 9999)
    private Integer year;

    @Column(name = "MONTH", nullable = false)
    @Range(min = 1, max = 12)
    private Integer month;

    @Override
    public int compareTo(Month month) {
        if (this.getYear().equals(month.getYear())) {
            return this.getMonth().compareTo(month.getMonth());
        }

        return this.getYear().compareTo(month.getYear());
    }
}
