package com.example.fitnessapp.Activty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.fitnessapp.Fragment.ChatFragment;
import com.example.fitnessapp.Fragment.HomeFragment;
import com.example.fitnessapp.Fragment.NotificationFragment;
import com.example.fitnessapp.Fragment.PaymentFragment;
import com.example.fitnessapp.Fragment.ProfileFragment;
import com.example.fitnessapp.R;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fitnessapp.Utility.SharedPreferencesManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            // Handle navigation item clicks

            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.nav_chat) {
                replaceFragment(new ChatFragment());
                return true;
            } else if (itemId == R.id.nav_notification) {
                replaceFragment(new NotificationFragment());
                return true;
            } else if (itemId == R.id.nav_payments) {
                replaceFragment(new PaymentFragment());
                return true;
            } else if (itemId == R.id.nav_profile) {
                replaceFragment(new ProfileFragment());
                return true;
            }

            return false;
        });

        // Set the default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_programs, new HomeFragment()).commit();
        }

        if (!SharedPreferencesManager.isUserDataStored(this)) {
            startActivity(new Intent(MainActivity.this, Login.class));
            finish();
        }
    }

    // Method to replace the current fragment with the selected one
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_programs, fragment).commit();
    }
}
