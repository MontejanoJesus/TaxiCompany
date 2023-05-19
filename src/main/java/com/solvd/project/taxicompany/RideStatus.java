package com.solvd.project.taxicompany;

public enum RideStatus {
    DISPATCHED, ON_THE_WAY, ARRIVED, COMPLETED;

    public String status() {
        switch (this) {
            case DISPATCHED -> {
                return "Ride is being dispatched";
            }
            case ON_THE_WAY -> {
                return "Ride is on the way";
            }
            case ARRIVED -> {
                return "Ride has arrived";
            }
            case COMPLETED -> {
                return "Ride has been completed";
            }
            default -> {
                return null;
            }
        }
    }


}

