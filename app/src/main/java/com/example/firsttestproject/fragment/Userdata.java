package com.example.firsttestproject.fragment;

import java.io.Serializable;

public class Userdata implements Serializable {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String emailid) {
        Emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    String username;
    String Emailid;
    String password;
    long phoneno;


    public Userdata(String username, String emailid, String password, long phoneno) {
        this.username = username;
        Emailid = emailid;
        this.password = password;
        this.phoneno = phoneno;
    }

}
