package com.example.senderreceiverbasicapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reciever implements Serializable {
    private String email;
    private String fullName;
    private String contact;
    private String country;
    private String address;

    @Override
    public String toString() {
        return fullName + ", " + country + ", " + address + ", " + contact;
    }
    public Reciever(String email, String fullName, String contact, String country, String address) {
        this.email = email;
        this.fullName = fullName;
        this.contact = contact;
        this.country = country;
        this.address = address;
    }
    public Reciever(String fullName,  String country, String address,String contact) {
        this.fullName = fullName;
        this.contact = contact;
        this.country = country;
        this.address = address;
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
