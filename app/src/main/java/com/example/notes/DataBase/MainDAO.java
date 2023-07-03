package com.example.notes.DataBase;


import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notes.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {

    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER by pinned DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes,date=:date where ID = :id")
    void update(int id,String title,String date,String notes);

    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned = :pin WHERE ID = :id ")
    void pin(int id,boolean pin);
}
