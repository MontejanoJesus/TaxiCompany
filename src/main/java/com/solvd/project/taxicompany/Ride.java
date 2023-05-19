package com.solvd.project.taxicompany;

import com.solvd.project.interfaces.IRide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Ride implements IRide {
    private static final Logger logger = LogManager.getLogger(Ride.class);
    private Address<String> startingAddress;
    private Address<String> endingAddress;
    private Driver driver;
    private Passenger passenger;
    private Double cost;

    public Ride() {
    }

    public Ride(Address<String> startingAddress, Address<String> endingAddress, Driver driver, Passenger passenger) {
        this.startingAddress = startingAddress;
        this.endingAddress = endingAddress;
        this.driver = driver;
        this.passenger = passenger;
    }

    public Address<String> getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(Address<String> startingAddress) {
        this.startingAddress = startingAddress;
    }

    public Address<String> getEndingAddress() {
        return endingAddress;
    }

    public void setEndingAddress(Address<String> endingAddress) {
        this.endingAddress = endingAddress;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }
    public void finishRide() {
        logger.info("\n" + RideStatus.COMPLETED.status());
    }

    @Override
    public String toString() {
        return "Ride{\n" +
                "Current Location=" + startingAddress +
                ",\n Destination=" + endingAddress +
                ",\n Driver=" + driver +
                ",\n Passenger=" + passenger +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Ride ride)) return false;
        return Objects.equals(getStartingAddress(), ride.getStartingAddress()) && Objects.equals(getEndingAddress(), ride.getEndingAddress()) && Objects.equals(getDriver(), ride.getDriver()) && Objects.equals(getPassenger(), ride.getPassenger());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartingAddress(), getEndingAddress(), getDriver(), getPassenger());
    }
}
