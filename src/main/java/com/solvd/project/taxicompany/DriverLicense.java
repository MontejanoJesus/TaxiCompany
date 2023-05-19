package com.solvd.project.taxicompany;

import java.util.Date;

public class DriverLicense {
    private Person owner;
    private Address<String> address;
    private Date expiration;
    private String licenseNumber;

    public DriverLicense() {}
    public DriverLicense(Person owner, Address<String> address, Date expiration, String licenseNumber) {
        this.owner = owner;
        this.address = address;
        this.expiration = expiration;
        this.licenseNumber = licenseNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Address<String> getAddress() {
        return address;
    }

    public void setAddress(Address<String> address) {
        this.address = address;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
