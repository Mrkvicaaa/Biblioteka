package com.example.knjizara.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.knjizara.MainActivity;
import com.example.knjizara.R;
import com.example.knjizara.Repository.FireBaseAuthRepository;
import com.example.knjizara.ViewModel.AuthViewModel;

public class LoginView extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private Button loginButton;
    private TextView registerLink;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        authViewModel.getLoginResult().observe(this, success -> {
            if (success) {
                Toast.makeText(this, "Prijava uspješna", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeView.class));
                finish();
            } else {
                Toast.makeText(this, "Prijava nije uspjela", Toast.LENGTH_SHORT).show();
            }
        });

        loginButton.setOnClickListener(v -> attemptLogin());
        registerLink.setOnClickListener(v -> {
            Intent intent = new Intent(LoginView.this, RegistracijaView.class);
            startActivity(intent);
        });
    }

    private void attemptLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Unesite email i lozinku", Toast.LENGTH_SHORT).show();
            return;
        }

        authViewModel.login(email, password);
    }
}
