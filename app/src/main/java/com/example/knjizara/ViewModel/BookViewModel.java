package com.example.knjizara.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.knjizara.Model.Book;
import com.example.knjizara.Repository.BookFsRepository;
import com.example.knjizara.Repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends ViewModel {

    private BookRepository repository;
    private BookFsRepository repositoryFs;
    private MutableLiveData<List<Book>> liveDatabooks;

    public void initRepository(Context context) {
        if (repository == null) {
            repository = new BookRepository(context);
//            liveDatabooks = repository.getBooks();
        }
    }

    public BookViewModel() {
        repository = null;
        repositoryFs = new BookFsRepository();
    }
}
