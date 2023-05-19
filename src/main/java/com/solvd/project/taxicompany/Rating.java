package com.solvd.project.taxicompany;

import com.solvd.project.interfaces.IRating;

import java.util.List;

public class Rating implements IRating {
    private Integer numberOfStars;
    private List<Review> reviews;

    public Rating() {}
    public Rating(Integer numberOfStars, List<Review> reviews) {
        this.numberOfStars = numberOfStars;
        this.reviews = reviews;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public void addReview(String review) {
        this.reviews.add(new Review(review));
    }

    @Override
    public String toString() {
        return "Rating{" +
                "numberOfStars=" + numberOfStars +
                ", reviews=" + reviews.toString() +
                '}';
    }
}
