package com.solvd.project.taxicompany;

import com.solvd.project.interfaces.IDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Driver extends Person implements IDriver {
    private static final Logger logger = LogManager.getLogger(Driver.class);
    private Rating rating;
    private Vehicle vehicle;
    private Account account;
    private DriverLicense license;

    public Driver() {}
    public Driver(String firstName, String lastName, Integer age, Vehicle vehicle, String username, String password,
                  String email, String phoneNumber, String bio) {
        super(firstName, lastName, age);
        this.vehicle = vehicle;
        this.account = new Profile(username, password, email, phoneNumber, bio);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public DriverLicense getLicense() {
        return license;
    }

    public void setLicense(DriverLicense license) {
        this.license = license;
    }

    public void printDriver() {
        logger.info("\n" + getFirstName() + " " + getLastName() + " : " + vehicle.getClass().getSimpleName() + "  " +
                rating.toString());

    }

    @Override
    public String toString() {
        return "Driver{" +
                "rating=" + rating +
                ", vehicle=" + vehicle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Driver driver)) return false;
        return Objects.equals(getAccount(), driver.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccount());
    }

    public void onTheWay() {
        logger.info("\n" + this.getFirstName() + " is on his way to your location");
        logger.info("\n" + RideStatus.ON_THE_WAY.status());
    }
    public void arrived() {
        logger.info("\n" + this.getFirstName() + " has arrived at your location");
        logger.info("\n" + RideStatus.ARRIVED.status());
    }
}
