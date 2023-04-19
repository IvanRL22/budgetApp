package com.budgetApp.application.crud.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ToString.Include
    @Column(name = "NAME", length = 30, nullable = false, unique = true)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "PARENT_CATEGORY")
    @JsonIgnoreProperties({"children"})
    private Category parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnoreProperties({"parent"})
    private Set<Category> children;

}
