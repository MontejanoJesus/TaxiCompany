package com.solvd.project.taxicompany;

import java.util.Objects;

public class Address<T extends String> {
    private T street;
    private T city;
    private T state;
    private T zipCode;

    public Address(){}

    public Address(T street, T city, T state, T zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public T getStreet() {
        return street;
    }

    public void setStreet(T street) {
        this.street = street;
    }

    public T getCity() {
        return city;
    }

    public void setCity(T city) {
        this.city = city;
    }

    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public T getZipCode() {
        return zipCode;
    }

    public void setZipCode(T zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getCity(),
                address.getCity()) && Objects.equals(getState(),
                address.getState()) && Objects.equals(getZipCode(), address.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getCity(), getState(), getZipCode());
    }
}
