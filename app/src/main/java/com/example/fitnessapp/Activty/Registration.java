package com.example.fitnessapp.Activty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessapp.Model.User;
import com.example.fitnessapp.R;
import com.example.fitnessapp.Utility.SharedPreferencesManager;

public class Registration extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText, confirmPasswordEditText,
            firstNameEditText, surnameEditText, displayNameEditText, dobEditText,
            phoneNumberEditText, emailEditText, addressEditText, countryEditText,
            personalWebpageEditText, roleEditText, notesEditText;
    // Add other fields for user registration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        displayNameEditText = findViewById(R.id.displayNameEditText);
        dobEditText = findViewById(R.id.dobEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        emailEditText = findViewById(R.id.emailEditText);
        addressEditText = findViewById(R.id.addressEditText);
        countryEditText = findViewById(R.id.countryEditText);
        personalWebpageEditText = findViewById(R.id.personalWebpageEditText);
        roleEditText = findViewById(R.id.roleEditText);
        notesEditText = findViewById(R.id.notesEditText);
        // Initialize other EditText fields

        findViewById(R.id.registerButton).setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();
            String firstName = firstNameEditText.getText().toString();
            String surname = surnameEditText.getText().toString();
            String displayName = displayNameEditText.getText().toString();
            String dob = dobEditText.getText().toString();
            String phoneNumber = phoneNumberEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String address = addressEditText.getText().toString();
            String country = countryEditText.getText().toString();
            String personalWebpage = personalWebpageEditText.getText().toString();
            String role = roleEditText.getText().toString();
            String notes = notesEditText.getText().toString();
            // Get values from other EditText fields

            // Perform registration (validate inputs, communicate with backend, etc.)
            if (isValidRegistration(username, password, confirmPassword, firstName, surname, displayName,
                    dob, phoneNumber, email, address, country, personalWebpage, role, notes)) {
                // Save user data (e.g., to a local database or communicate with backend)
                // Navigate to the main screen or perform other actions

                // Assuming you have a User object named newUser

                User newUser = new User(
                        username,
                        password,
                        firstName,
                        surname,
                        displayName,
                        dob,
                        phoneNumber,
                        email,
                        address,
                        country,
                        personalWebpage,
                        role,
                        notes
                );

                if (SharedPreferencesManager.saveUser(getApplicationContext(), newUser)) {
                    startActivity(new Intent(Registration.this, MainActivity.class));
                    finish();
                }

            } else {
                Toast.makeText(Registration.this, "Invalid registration details", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidRegistration(String username, String password, String confirmPassword,
                                        String firstName, String surname, String displayName, String dob,
                                        String phoneNumber, String email, String address, String country,
                                        String personalWebpage, String role, String notes) {
        // Implement your registration validation logic (e.g., check against backend, validate password constraints)
        // For simplicity, a basic check is done here
        return username.length() >= 6 && password.length() >= 8 && password.equals(confirmPassword);
    }
}
