package com.example.knjizara.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.knjizara.Model.Book;

import java.util.List;

@Dao
public abstract class BookDao {

    @Transaction
    @Query("SELECT * FROM books")
    public abstract LiveData<List<Book>> getAllBooks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertBooks(List<Book> books);
}
