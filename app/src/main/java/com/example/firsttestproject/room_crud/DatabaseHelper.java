package com.example.firsttestproject.room_crud;

import android.content.Context;

import androidx.room.Room;

public class DatabaseHelper {

    static NotesDatabase getDatabase(Context context) {

        NotesDatabase database = Room.databaseBuilder(context, NotesDatabase.class, "EmpDatabase")
                .allowMainThreadQueries()
                .build();

        return database;
    }
}

