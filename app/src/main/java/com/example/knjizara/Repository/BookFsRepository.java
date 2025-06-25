package com.example.knjizara.Repository;

import android.util.Log;

import com.example.knjizara.Model.Book;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class BookFsRepository {

    private final CollectionReference booksRef;

    public BookFsRepository() {
        booksRef = FirebaseFirestore.getInstance().collection("Books");
    }

    public void getBooks(ValueEventListener listener) {
        booksRef.addSnapshotListener((value, error) -> {
            if (error != null || value == null) return;

            List<Book> bookList = new ArrayList<>();
            for (DocumentSnapshot doc : value.getDocuments()) {
                try {
                    String naziv = doc.getString("Naziv");
                    String autor = doc.getString("autor");
                    String opis = doc.getString("opis");
                    String slikaUrl = doc.getString("slikaUrl");
                    Double ocjenaDouble = doc.getDouble("ocjena");
                    float ocjena = ocjenaDouble != null ? ocjenaDouble.floatValue() : 0f;

                    Book book = new Book(naziv, autor, opis, ocjena, slikaUrl);
                    bookList.add(book);
                } catch (Exception e) {
                    Log.e("FirestoreParse", "Greška kod parsiranja dokumenta", e);
                }
            }
            listener.onBooksReceived(bookList);
        });
    }

    public void insertBook(Book book) {
        booksRef.add(book);
    }

    public interface ValueEventListener {
        void onBooksReceived(List<Book> books);
    }
}
