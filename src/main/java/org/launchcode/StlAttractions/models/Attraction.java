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

//    @OneToMany(mappedBy = "attraction")
//    private List<Review> reviews = new ArrayList<>();

    @NotNull(message = "Name is required.")
    @Size(min=1, max=150)
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotNull(message = "Address is required.")
    private String address;

    private String linkForAttraction;

    private String minutesOpen;

    private String timeOfDayOpen;

    private String hoursOfOperationOpen;

    private String hoursOfOperationEnd;

    private String minutesEnd;



    private String timeOfDayEnd;


    public Attraction(String name,Category category , String description,String address, String linkForAttraction,String hoursOfOperationOpen, String minutesOpen, String timeOfDayOpen, String hoursOfOperationEnd,
                      String minutesEnd, String timeOfDayEnd) {
        super();
        this.name = name;
        this.category = category;
        this.description = description;
        this.address = address;
        this.linkForAttraction = linkForAttraction;
        this.hoursOfOperationOpen = hoursOfOperationOpen;
        this.minutesOpen = minutesOpen;
        this.timeOfDayOpen = timeOfDayOpen;
        this.hoursOfOperationEnd = hoursOfOperationEnd;
        this.minutesEnd = minutesEnd;
        this.timeOfDayEnd = timeOfDayEnd;

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

    public String getHoursOfOperationOpen() { return hoursOfOperationOpen; }

    public void setHoursOfOperationOpen(String hoursOfOperationOpen) { this.hoursOfOperationOpen = hoursOfOperationOpen; }

    public String getMinutesOpen() { return minutesOpen; }

    public void setMinutesOpen(String minutesOpen) { this.minutesOpen = minutesOpen; }

    public String getTimeOfDayOpen() { return timeOfDayOpen; }

    public void setTimeOfDayOpen(String timeOfDayOpen) { this.timeOfDayOpen = timeOfDayOpen; }

    public String getHoursOfOperationEnd() { return hoursOfOperationEnd; }

    public void setHoursOfOperationEnd(String hoursOfOperationEnd) { this.hoursOfOperationEnd = hoursOfOperationEnd; }

    public String getMinutesEnd() { return minutesEnd; }

    public void setMinutesEnd(String minutesEnd) { this.minutesEnd = minutesEnd; }

    public String getTimeOfDayEnd() { return timeOfDayEnd; }

    public void setTimeOfDayEnd(String timeOfDayEnd) { this.timeOfDayEnd = timeOfDayEnd; }


    @Override
    public String toString() {
        return name;
    }


}
