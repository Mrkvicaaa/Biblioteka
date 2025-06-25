package com.example.knjizara.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.knjizara.Repository.BookFsRepository;

@Entity(tableName = "books")
public class Book {

    public Book() {
    }

    public Book(String naziv, String autor, String opis, float ocjena, String slikaUrl) {
        Naziv = naziv;
        this.autor = autor;
        this.opis = opis;
        this.ocjena = ocjena;
        this.slikaUrl = slikaUrl;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String Naziv;
    public String autor;
    public String opis;
    public float ocjena;
    public String slikaUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getOcjena() {
        return ocjena;
    }

    public void setOcjena(float ocjena) {
        this.ocjena = ocjena;
    }

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }
}

