package com.example.firsttestproject.room_crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Notes.class},version = 1,exportSchema = false)
abstract public class NotesDatabase  extends RoomDatabase {

    public abstract  NotesDAO getDAO();
}
