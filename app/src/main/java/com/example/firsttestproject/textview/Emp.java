package com.example.firsttestproject.textview;

import java.io.Serializable;

public class Emp implements Serializable {
    int id;
    String Name;
    String Field;
    int selery;
    String Address;

    public Emp(int id, String name, String field, int selery, String address) {
        this.id = id;
        Name = name;
        Field = field;
        this.selery = selery;
        Address = address;
    }

}
