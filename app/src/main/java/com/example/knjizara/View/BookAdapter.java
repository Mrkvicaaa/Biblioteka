package com.example.knjizara.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knjizara.Model.Book;
import com.example.knjizara.R;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList = new ArrayList<>();

    public void setBookList(List<Book> books) {
        this.bookList = books;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.naziv.setText(book.Naziv);
        holder.autor.setText(book.autor);
        holder.opis.setText(book.opis);
        holder.ocjena.setRating(book.ocjena);

        // Ako koristiš slike iz drawable foldera
        int resId = holder.itemView.getContext().getResources()
                .getIdentifier(book.slikaUrl, "drawable", holder.itemView.getContext().getPackageName());

        if (resId != 0) {
            holder.Slika.setImageResource(resId);
        } else {
            holder.Slika.setImageResource(R.drawable.logo_sova); // rezervna slika ako fali
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView Slika;
        TextView naziv, autor, opis;
        RatingBar ocjena;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            Slika = itemView.findViewById(R.id.bookImage);
            naziv = itemView.findViewById(R.id.bookTitle);
            autor = itemView.findViewById(R.id.bookAuthor);
            opis = itemView.findViewById(R.id.bookDescription);
            ocjena = itemView.findViewById(R.id.bookRating);
        }
    }
}
