package org.launchcode.StlAttractions.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Category extends AbstractEntity {
    @NotNull
    @Size(min = 3, max = 150)
    private String name;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
            name="categories_attractions",
            joinColumns = @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="attraction_id")

    )
    private List<Attraction> attractions;

    public Category(String aName) {
        super();
        this.name = aName;
    }

    public Category() {
    }

    // Getters and Setters //


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

