package com.solvd.project.taxicompany;
/* The application starts with the passenger(John Marsh) entering information
    to get a ride from a taxi company called RideAlong.
* */
/* *
/*  5/05 fix packages, no public in linked list, FileUtils/StringUtils
/*  5/09 Enum (RideStatus) Lambda used to print out employess line 107, sort employees line 72
/*      Streams used in Company class to filter employees and accounts
 * */


import com.solvd.project.exceptions.IllegalChoiceException;
import com.solvd.project.interfaces.IDisplay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Create passenger
        List<Account> accounts = new ArrayList<>();
        Passenger passenger = new Passenger("John", "Marsh", 28, "johnmarsh",
                "john123", "johnmarsh@yahoo.com","8001423594", "Cant wait to get to my destination");
        accounts.add(passenger.getAccount());
        List<Review> passengerReviews = new ArrayList<>();
        Review r1 = new Review("John was an excellent passenger.");
        passengerReviews.add(r1);
        Review r2 = new Review("Was a pleasure to have.");
        passengerReviews.add(r2);
        Rating passengerRating = new Rating(4, passengerReviews);
        passenger.setRating(passengerRating);
        passenger.getRating().addReview("Great passenger.");

        // Set up drivers
        Compact v1 = new Compact("2020", "Honda", "Civic", "White");
        SUV v2 = new SUV("2019", "Ford", "Expedition", "Black");
        Driver driver1 = new Driver("Gary", "Long", 33, v1, "garylong", "gary123",
                "garylong@yahoo.com", "8001541234", "I love hiking and traveling");
        DriverLicense driver1License = new DriverLicense(driver1, new Address<>("123 Long drive", "Los Angeles", "CA", "90001"),
                 new Date(2025, Calendar.FEBRUARY, 28), "D12345678");
        driver1.setLicense(driver1License);
        accounts.add(driver1.getAccount());
        List<Review> d1Reviews = new ArrayList<>();
        Review r3 = new Review("Gary was an excellent driver.");
        d1Reviews.add(r3);
        Review r4 = new Review("Was a pleasure to have as my driver.");
        d1Reviews.add(r4);
        Rating driver1Rating = new Rating(5, d1Reviews);
        driver1.setRating(driver1Rating);
        Driver driver2 = new Driver("Alex", "Albon", 29, v2, "alexalbon", "alex123",
                "alexalabon@gmail.com", "8007891234", "Love getting the chance to take people to " +
                "their destinations");
        DriverLicense driver2License = new DriverLicense(driver2, new Address<>("123 Sixth street", "Los Angeles", "CA", "90001"),
                new Date(2029, Calendar.NOVEMBER, 3), "D87654321");
        driver2.setLicense(driver2License);
        accounts.add(driver2.getAccount());
        List<Review> d2Reviews = new ArrayList<>();
        Review r5 = new Review("Alex was an excellent driver.");
        Review r6 = new Review("Was a pleasure to have as my driver.");
        d2Reviews.add(r5);
        d2Reviews.add(r6);
        Rating driver2Rating = new Rating(3, d2Reviews);
        driver2.setRating(driver2Rating);
        List<Driver> employees = new ArrayList<>();
        employees.add(driver1);
        employees.add(driver2);

        // Company that has drivers as employees
        Company<Driver> company = new Company<>("RideAlong", employees, accounts);
        // Sort employees using lambda
        company.getEmployees().sort(Comparator.comparing(Person::getLastName));

        // Start process for a ride
        Ride ride = new Ride();
        ride.setPassenger(passenger);
        Scanner input = new Scanner(System.in);
        // Prompt user to get starting location for ride
        Address<String> startingAddress = new Address<>();
        logger.info("\nWelcome " + passenger.getFirstName() + " " + passenger.getLastName() +
                " to " + company.getName());
        logger.info("\n****************************************\n");
        logger.info("To start a ride please enter your current address: \n");
        logger.info("Street: ");
        startingAddress.setStreet(input.nextLine());
        logger.info("\nCity: ");
        startingAddress.setCity(input.nextLine());
        logger.info("\nState: ");
        startingAddress.setState(input.nextLine());
        logger.info("\nZipCode: ");
        startingAddress.setZipCode(input.nextLine());
        logger.info("\nNow, where would you like to go?");
        ride.setStartingAddress(startingAddress);

        // Prompt for destination
        Address<String> destination = new Address<>();
        logger.info("\nStreet: ");
        destination.setStreet(input.nextLine());
        logger.info("\nCity: ");
        destination.setCity(input.nextLine());
        logger.info("\nState: ");
        destination.setState(input.nextLine());
        logger.info("\nZipCode: ");
        destination.setZipCode(input.nextLine());
        ride.setEndingAddress(destination);

        // Driver selection
        logger.info("\nSelect a driver: ");
        company.getEmployees().forEach(e -> {
            logger.info("\n" + e.getFirstName() + " " + e.getLastName()
                    + " " + e.getVehicle().getClass().getSimpleName() +
                     ": " + e.getRating().toString());
        });
        logger.info("\nPlease select a driver: ");
        int driverChoice = 0;
        try {
            driverChoice = input.nextInt();
            if(driverChoice < 0 || driverChoice > employees.size())
                throw new IllegalChoiceException();
        }
        catch(IllegalChoiceException  | InputMismatchException e) {
            logger.error("That is not a valid choice.");
        }

        ride.setDriver(employees.get(driverChoice - 1));

        // Print details of ride and dispatch driver
        company.dispatchDriver(employees.get(driverChoice - 1));
        logger.info("\n\n");
        logger.info("Here are the details to your ride:");
        IDisplay rideDisplay = () -> {
            return "From: " + ride.getStartingAddress().toString() + "\nTo: " + ride.getEndingAddress().toString() +
                     "\nDriver " + ride.getDriver().getFirstName();
        };
        rideDisplay.display();

        logger.info("\n\n");

        // Driver on route/arriving
        Driver currentDriver = ride.getDriver();
        currentDriver.onTheWay();
        logger.info("\nCouple minutes later...\n\n");
        currentDriver.arrived();
        logger.info("\nCouple more minutes later...\n\n");
        ride.finishRide();
        if(currentDriver.getVehicle().getClass().getSimpleName().equals("Compact")) {
            ride.setCost(15d);
        } else {
            ride.setCost(20d);
        }
        logger.info("\nYour ride cost: " + ride.getCost());
        ride.getPassenger().pay(ride.getCost());
        logger.info("""

                 ********************
                Add a review for the driver below:\s""");
        String newReview = input.nextLine();
        currentDriver.getRating().addReview(newReview);

        input.close();
    }
}
