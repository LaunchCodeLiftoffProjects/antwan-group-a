package org.launchcode.StlAttractions.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Attraction extends AbstractEntity{


    private String attractionCategory;
    private String attractionName;
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotNull
    @Size(min=1, max=150)
    private String address;
    private String linkForAttraction;


    public Attraction(String attractionCategory,String attractionName, String description,String address, String linkForAttraction) {
        this.attractionName = attractionName;
        this.description = description;
        this.address = address;
        this.linkForAttraction = linkForAttraction;
        this.attractionCategory = attractionCategory;

    }

    public Attraction() {}
    public String getAttractionCategory() {return attractionCategory;}

    public void setAttractionCategory(String attractionCategory) {this.attractionCategory = attractionCategory;}

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

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
        return attractionName;
    }


}
