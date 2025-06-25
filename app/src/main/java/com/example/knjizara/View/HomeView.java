package com.example.knjizara.View;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.knjizara.App;
import com.example.knjizara.R;
import com.example.knjizara.Repository.BookFsRepository;
import com.example.knjizara.ViewModel.BookViewModel;
import com.google.android.material.navigation.NavigationView;

public class HomeView extends AppCompatActivity {

    private BookAdapter bookAdapter;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);

        // Direktno pozivamo funkciju iz BookFsRepository
        new BookFsRepository().getBooks(books -> {
            runOnUiThread(() -> bookAdapter.setBookList(books));
        });


//        bookViewModel.initRepository(App.getInstance().getApplicationContext());
//        bookViewModel.getBooks().observe(this, books -> bookAdapter.setBookList(books));

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout,toolbar, R.string.otvori_navigaciju, R.string.zatvori_navigaciju);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, LoginView.class));
            } else if (id == R.id.nav_settings) {
                startActivity(new Intent(this, RegistracijaView.class));
            } else if (id == R.id.nav_logout) {
                startActivity(new Intent(this,LoginView.class));
            }
            drawerLayout.closeDrawers();
            return true;
        });

    }
}
