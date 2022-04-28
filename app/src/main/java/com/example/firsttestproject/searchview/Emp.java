package com.example.firsttestproject.searchview;


public class Emp  {
    String Name;
    String Field;
    int Salary;
    String Address;

    public Emp(String name, String field, int salary, String address) {
        Name = name;
        Field = field;
        this.Salary = salary;
        Address = address;
    }

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

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        this.Salary = salary;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
