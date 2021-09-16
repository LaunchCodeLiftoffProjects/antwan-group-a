package org.launchcode.StlAttractions.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends AbstractEntity {

    private String reviewText;

    @ManyToOne
    private Attraction attraction;

    @ManyToOne
    private User user;

    public Review() {}

    public Review(String reviewText) {
        this.reviewText = reviewText;
    }

    public Review(String reviewText, Attraction attraction, User user) {
        this.reviewText = reviewText;
        this.attraction = attraction;
        this.user = user;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return reviewText;
    }
}