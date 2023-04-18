package com.budgetApp.application.crud.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", length = 30, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY")
    @JsonIgnoreProperties({"children"})
    private Category parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnoreProperties({"parent"})
    private Set<Category> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Category> getChildren() {
        return children;
    }

    public void setChildren(Set<Category> children) {
        this.children = children;
    }

}
