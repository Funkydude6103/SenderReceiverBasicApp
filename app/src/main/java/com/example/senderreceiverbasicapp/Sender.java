package com.example.senderreceiverbasicapp;

import java.io.Serializable;

public class Sender implements Serializable {
    private String email;
    private String fullName;
    private String contact;
    private String country;
    private String address;

    public Sender(String email, String fullName, String contact, String country, String address) {
        this.email = email;
        this.fullName = fullName;
        this.contact = contact;
        this.country = country;
        this.address = address;
    }
    public Sender(String fullName,  String country, String address,String contact) {
        this.fullName = fullName;
        this.contact = contact;
        this.country = country;
        this.address = address;
    }
    @Override
    public String toString() {
        return fullName + ", " + country + ", " + address + ", " + contact;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
