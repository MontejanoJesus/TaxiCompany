package com.solvd.project.taxicompany;

public class SUV extends Vehicle{
    public final Integer maxNumberOfPassengers = 7;

    public SUV() {}
    public SUV(String year, String make, String model, String color) {
        super(year, make, model, color);

    }

    public Integer getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }
}
