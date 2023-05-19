package com.solvd.project.taxicompany;

import com.solvd.project.interfaces.IPassenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Passenger extends Person implements IPassenger {
    private static final Logger logger = LogManager.getLogger(Passenger.class);
    private Rating rating;
    private Account account;

    public Passenger() {}
    public Passenger(String firstName, String lastName, Integer age, String username, String password,
                     String email, String phoneNumber, String bio) {
        super(firstName, lastName, age);
        this.account = new Profile(username, password, email, phoneNumber, bio);
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void pay(Double cost) {
        logger.info("\nPassenger successfully paid " + cost);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return Objects.equals(getAccount(), passenger.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccount());
    }
}
