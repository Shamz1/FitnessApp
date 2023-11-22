package com.example.fitnessapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fitnessapp.Activty.CalendarActivity;
import com.example.fitnessapp.Activty.ClassesActivity;
import com.example.fitnessapp.Activty.Programms;
import com.example.fitnessapp.R;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the MaterialCardViews
        MaterialCardView calendarCard = view.findViewById(R.id.calendarCard);
        MaterialCardView programmesCard = view.findViewById(R.id.programmesCard);
        MaterialCardView classesCard = view.findViewById(R.id.classesCard);

        // Set OnClickListener for each card
        calendarCard.setOnClickListener(v -> {
            // Launch the CalendarActivity or your desired activity here
            startActivity(new Intent(getActivity(), CalendarActivity.class));
        });

        programmesCard.setOnClickListener(v -> {
            // Launch the ProgrammesActivity or your desired activity here
            startActivity(new Intent(getActivity(), Programms.class));
        });

        classesCard.setOnClickListener(v -> {
            // Launch the ClassesActivity or your desired activity here
            startActivity(new Intent(getActivity(), ClassesActivity.class));
        });

        return view;
    }

}
