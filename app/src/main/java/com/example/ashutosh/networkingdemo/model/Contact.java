package com.example.ashutosh.networkingdemo.model;

/**
 * Created by Ashutosh on 24-09-2016.
 */
public class Contact {
    private String name,email,phone;

    public Contact(String name, String email, String phone)
    {
        this.name=name;
        this.email=email;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
