package com.example.knjizara.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.knjizara.Model.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class RoomDataBase extends RoomDatabase {
    public abstract BookDao bookDao();
}
