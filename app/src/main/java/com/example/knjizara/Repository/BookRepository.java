package com.example.knjizara.Repository;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.knjizara.DataBase.BookDao;
import com.example.knjizara.DataBase.DataBaseClient;
import com.example.knjizara.Model.Book;

import java.util.List;
import java.util.concurrent.Executors;
public class BookRepository {

    private final BookDao bookDao;

    public BookRepository(Context context) {
        bookDao = DataBaseClient.getInstance(context).getDatabase().bookDao();
    }

    public LiveData<List<Book>> getBooks() {
        return bookDao.getAllBooks();
    }

    public void insertBooks(List<Book> books) {
        Executors.newSingleThreadExecutor().execute(() -> bookDao.insertBooks(books));
    }
}
