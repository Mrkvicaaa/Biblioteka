package com.example.knjizara.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.knjizara.R;
import com.example.knjizara.ViewModel.AuthViewModel;

public class RegistracijaView extends AppCompatActivity {

    private EditText nameInput, emailInput, passwordInput, repeatPasswordInput;
    private Button registerButton;
    private TextView loginLink;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registracija);

        authViewModel = new AuthViewModel();

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        repeatPasswordInput = findViewById(R.id.repeatPasswordInput);
        registerButton = findViewById(R.id.registerButton);
        loginLink = findViewById(R.id.loginLink);

        authViewModel.getRegisterResult().observe(this, success -> {
            if (success) {
                Toast.makeText(this, "Registra uspješna", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginView.class));
                finish();
            } else {
                Toast.makeText(this, "Registracija nije uspjela", Toast.LENGTH_SHORT).show();
            }
        });

        registerButton.setOnClickListener(v -> registerUser());

        loginLink.setOnClickListener(v -> {
            Intent intent = new Intent(RegistracijaView.this, LoginView.class);
            startActivity(intent);
            finish();
        });
    }

    private void registerUser() {

        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String password2 = repeatPasswordInput.getText().toString().trim();

        if(password==password2){
            Toast.makeText(this, "Loznke nisu iste", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Popunite sva polja", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Lozinka mora imati najmanje 6 karaktera", Toast.LENGTH_SHORT).show();
            return;
        }

        authViewModel.register(email,password);
    }
}
