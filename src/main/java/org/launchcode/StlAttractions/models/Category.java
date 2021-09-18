package org.launchcode.StlAttractions.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractEntity{

    /*    @JoinColumn(name = "cuisine_id")*/
    @OneToMany(mappedBy = "category")
    private List<Attraction> attraction = new ArrayList<>();

    @NotNull
    @Size(min=3, max=150)
    private String name;

    public Category(String aName/*, List<Restaurant> aRestaurant*/) {
        super();
        this.name = aName;
        /*        this.restaurant = aRestaurant;*/
    }

    public Category() { }

    // Getters and Setters //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public List<Restaurant> getRestaurant() { return restaurant; }
    public void setRestaurant(List<Restaurant> restaurant) { this.restaurant = restaurant; }*/

    @Override
    public String toString() {
        return name;
    }
}