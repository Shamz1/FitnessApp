package com.example.fitnessapp.Activty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessapp.R;
import com.example.fitnessapp.Utility.SharedPreferencesManager;

public class Login extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.login_emailEditText);
        passwordEditText = findViewById(R.id.login_passwordEditText);

        findViewById(R.id.loginButton).setOnClickListener(v -> {
            String userEmail = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Perform login authentication (check credentials, communicate with backend, etc.)
            if (isValidCredentials(password)) {
                // Navigate to the main screen or perform other actions

                if (SharedPreferencesManager.loginUser(Login.this, userEmail, password)) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(Login.this, "No User found, please register!", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.registerTextView).setOnClickListener(v -> {
            // Navigate to the registration screen
            startActivity(new Intent(Login.this, Registration.class));
        });
    }

    private boolean isValidCredentials(String password) {
        // Implement your authentication logic (e.g., check against backend, verify password constraints)
        // For simplicity, a basic check is done here
        return password.length() >= 8;
    }


}
