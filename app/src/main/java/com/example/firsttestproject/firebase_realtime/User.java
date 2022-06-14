package com.example.firsttestproject.firebase_realtime;

public class User {

    String Name;
    String Field;
    float Salary;
    String Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public User(String name, String field, float salary, String address) {
        Name = name;
        Field = field;
        Salary = salary;
        Address = address;
    }
}
