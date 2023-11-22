package com.example.fitnessapp.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.fitnessapp.Model.User;
import com.google.gson.Gson;

public class SharedPreferencesManager {

    private static final String USER_PREFS = "user_prefs";
    private static final String USER_KEY = "user_key";

    // Save user to SharedPreferences
    public static boolean saveUser(Context context, User user) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Convert User object to JSON string
        Gson gson = new Gson();
        String userJson = gson.toJson(user);

        // Save JSON string to SharedPreferences
        editor.putString(USER_KEY, userJson);
        editor.apply();

        return true;
    }

    // Retrieve user from SharedPreferences
    public static User getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);

        // Retrieve JSON string from SharedPreferences
        String userJson = sharedPreferences.getString(USER_KEY, "");

        // Convert JSON string to User object
        Gson gson = new Gson();
        return gson.fromJson(userJson, User.class);
    }

    // Clear user data from SharedPreferences
    public static void clearUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    // Check if the entered email and password match with saved data
    public static boolean loginUser(Context context, String enteredEmail, String enteredPassword) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);

        // Retrieve JSON string from SharedPreferences
        String userJson = sharedPreferences.getString(USER_KEY, "");

        // Convert JSON string to User object
        Gson gson = new Gson();
        User savedUser = gson.fromJson(userJson, User.class);

        // Check if the entered email and password match with saved data
        return savedUser != null &&
                enteredEmail.equals(savedUser.getEmail()) &&
                enteredPassword.equals(savedUser.getPassword());
    }

    // Check if user data is stored in SharedPreferences
    public static boolean isUserDataStored(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);

        // Retrieve JSON string from SharedPreferences
        String userJson = sharedPreferences.getString(USER_KEY, "");

        // Return true if user data is not empty, false otherwise
        return !TextUtils.isEmpty(userJson);
    }
}
