package org.launchcode.StlAttractions.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Attraction extends AbstractEntity{


    private String name;

    @Size(max = 500, message = "Description too long!")
    private String category;
    private String description;

    @NotNull
    private String address;
    private String linkForAttraction;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Category>  attractions=new ArrayList<>();


    public Attraction(String name,String category, String description,String address, String linkForAttraction, List<Category> attractions) {
        super();
        this.name = name;
        this.category = category;
        this.description = description;
        this.address = address;
        this.linkForAttraction = linkForAttraction;
        this.attractions = attractions;

    }
    public void addAttraction(Category newAttraction){
        attractions.add(newAttraction);
    }

    public Attraction() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getAttractions() {return attractions;}

    public void setAttractions(List<Category> attractions) {this.attractions = attractions;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getLinkForAttraction() { return linkForAttraction; }

    public void setLinkForAttraction(String linkForAttraction) { this.linkForAttraction = linkForAttraction; }


    @Override
    public String toString() {
        return name;
    }


}
