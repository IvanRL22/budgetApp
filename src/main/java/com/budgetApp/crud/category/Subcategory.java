package com.budgetApp.crud.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public final class Subcategory extends AbstractCategory {

    @ManyToOne(optional = false, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    @JsonIgnoreProperties("children")
    private Category parent;
}
