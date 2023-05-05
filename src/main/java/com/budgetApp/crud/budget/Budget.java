package com.budgetApp.crud.budget;

import com.budgetApp.business.interfaces.Identifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BUDGETS")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Budget implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", length = 30)
    private String name;

    @ToString.Exclude
    @Column(name = "DESCRIPTION")
    private String description;
}
