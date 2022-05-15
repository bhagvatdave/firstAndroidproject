package com.example.firsttestproject.room_crud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "notesTable")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    int key;

    @ColumnInfo()
    String Title;

    @ColumnInfo()
    String Description;

    public Notes(String title, String description) {
        Title = title;
        Description = description;
    }

    public Notes(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "key=" + key +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
