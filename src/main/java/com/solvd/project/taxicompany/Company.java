package com.solvd.project.taxicompany;

import com.solvd.project.interfaces.ICompany;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Company<T extends Person> implements ICompany{
    private static final Logger logger = LogManager.getLogger(Company.class);
    private String name;
    private List<T> employees;
    private List<Account> accounts;
    public Company() {}

    public Company(String name, List<T> employees, List<Account> accounts) {
        this.name = name;
        this.employees = employees;
        this.accounts = accounts;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void dispatchDriver(Driver driver) {
        logger.info("\n" + driver.getFirstName() + " " + driver.getLastName() + " has been notified of your ride.");
        logger.info("\n" + RideStatus.DISPATCHED.status());
    }
}
