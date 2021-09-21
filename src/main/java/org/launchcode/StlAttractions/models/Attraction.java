package org.launchcode.StlAttractions.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Attraction extends AbstractEntity{


    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "attraction")
    private List<Review> reviews = new ArrayList<>();

    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotNull
    private String address;
    private String linkForAttraction;

    @NotNull(message = "Hours is required.")
    private String openingTime;

    @NotNull(message = "Hours is required.")
    private String closingTime;


    public Attraction(String name,Category category , String description,String address, String linkForAttraction, String aOpeningTime, String aClosingTime, List<Review> reviews) {
        super();
        this.name = name;
        this.category = category;
        this.description = description;
        this.address = address;
        this.linkForAttraction = linkForAttraction;
        this.openingTime = aOpeningTime;
        this.closingTime = aClosingTime;
        this.reviews = reviews;
    }


    public Attraction() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

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

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public List<Review> getReviews() {return reviews;}

    public void setReviews(List<Review> reviews) {this.reviews = reviews;}


    @Override
    public String toString() {
        return name;
    }


}
