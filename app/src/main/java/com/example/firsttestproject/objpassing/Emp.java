package com.example.firsttestproject.objpassing;

import java.io.Serializable;

public class Emp implements Serializable {
    int id;
    String Name;
    String Field;
    int Selery;
    String Address;

    public Emp(int id, String name, String field, int selery, String address) {
        this.id = id;
        Name = name;
        Field = field;
        this.Selery = selery;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSelery() {
        return Selery;
    }

    public void setSelery(int selery) {
        this.Selery = selery;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
