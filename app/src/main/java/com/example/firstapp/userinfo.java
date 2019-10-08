package com.example.firstapp;

public class userinfo {
    String fname;
    String email;
    String phone;
    String lname;

    public userinfo(String fname, String email, String phone, String lname) {
        this.fname = fname;
        this.email = email;
        this.phone = phone;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLname() {
        return lname;
    }
}
