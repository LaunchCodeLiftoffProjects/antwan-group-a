package org.launchcode.StlAttractions.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Category extends AbstractEntity{

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Attraction> attraction = new ArrayList<>();

    @NotNull(message = "Name is required.")
    @Size(min=3, max=150)
    private String name;

    public Category(String name, List<Attraction> attraction) {
        super();
        this.name = name;
        this.attraction = attraction;
    }

    public Category() { }

    // Getters and Setters //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attraction> getAttraction() { return attraction; }

    public void setAttraction(List<Attraction> attraction) { this.attraction = attraction; }

    @Override
    public String toString() {
        return name;
    }
}