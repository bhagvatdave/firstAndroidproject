package com.example.firsttestproject.room_crud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDAO {

    @Insert
    void insertData(Notes n);

    @Update
    void updateData(Notes n);

    @Delete
    void deleteData(Notes n);

    @Query("select * from NotesTable")
    List<Notes> showData();

    @Query("select * from NotesTable where 'key'=:key")
    List<Notes> showSpecificEmpData(int key);

    @Insert
    void insertWholeList(List<Notes> list);

    @Update
    void updateWholeList(List<Notes> list);

    @Query("delete from NotesTable where 'key'=:key")
    void deleteData2(int key);

    @Query("select COUNT(*) from NotesTable")
    int numberOfData();

    @Query("select * From NotesTable where Title Like :data or Description Like :data")
    Notes finddata(String data);

}
