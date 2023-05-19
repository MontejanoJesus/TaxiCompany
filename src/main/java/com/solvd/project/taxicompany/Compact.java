package com.solvd.project.taxicompany;

public class Compact extends Vehicle{
    public final Integer maxNumberOfPassengers = 4;
    public Compact() {}

    public Compact(String year, String make, String model, String color) {
        super(year, make, model, color);
    }

    public Integer getNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public Integer getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }
}
