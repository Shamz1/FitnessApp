package com.example.fitnessapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fitnessapp.Activty.Login;
import com.example.fitnessapp.Model.User;
import com.example.fitnessapp.R;
import com.example.fitnessapp.Utility.SharedPreferencesManager;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Retrieve stored user data from SharedPreferences
        User user = SharedPreferencesManager.getUser(getContext());

        // Check if user data is available
        if (user != null) {
            // Set user data to the TextViews
            TextView userName = view.findViewById(R.id.userName1);
            TextView userRole = view.findViewById(R.id.userRole);
            TextView userPhone = view.findViewById(R.id.userPhone);
            TextView userEmail = view.findViewById(R.id.userEmail);
            TextView userSurName = view.findViewById(R.id.userSurName);
            TextView userDob = view.findViewById(R.id.userDob);
            TextView userAddress = view.findViewById(R.id.userAddress);
            TextView userWebpageUrl = view.findViewById(R.id.userWebpageUrl);
            TextView userNote = view.findViewById(R.id.userNote);

            userName.setText(user.getDisplayName());
            userRole.setText(user.getRole());
            userPhone.setText(user.getPhoneNumber());
            userEmail.setText(user.getEmail());
            userSurName.setText(user.getSurname());
            userDob.setText(user.getDob());
            userAddress.setText(user.getAddress());
            userWebpageUrl.setText(user.getPersonalWebpage());
            userNote.setText(user.getNotes());

        }

        view.findViewById(R.id.btnLogout).setOnClickListener(view1 -> {
            SharedPreferencesManager.clearUser(getContext());
            startActivity(new Intent(getContext(), Login.class));
            requireActivity().finish();
        });

        return view;
    }
}
