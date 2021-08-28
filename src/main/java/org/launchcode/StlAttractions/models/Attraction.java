package org.launchcode.StlAttractions.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Attraction extends AbstractEntity{

    @NotNull
    @Size(min=3, max=150)
    private String name;
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
            name="categories_attractions",
            joinColumns = @JoinColumn(name="attraction_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")

    )
    private List<Category> categories;
    @NotNull
    @Size(min=1, max=150)
    private String address;


    private String hoursOfOperation;
    private String linkForAttraction;

    public Attraction(Long id, String aName, String anAddress, String aHoursOfOperation, String aLinkForAttraction) {
        super();
        this.name = aName;
        this.address = anAddress;
        this.hoursOfOperation = aHoursOfOperation;
        this.linkForAttraction = aLinkForAttraction;
    }

    public Attraction() { }

    // Getters and Setters //


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getHoursOfOperation() { return hoursOfOperation; }

    public void setHoursOfOperation(String hoursOfOperation) { this.hoursOfOperation = hoursOfOperation; }

    public String getLinkForAttraction() { return linkForAttraction; }

    public void setLinkForAttraction(String linkForAttraction) { this.linkForAttraction = linkForAttraction; }


}


