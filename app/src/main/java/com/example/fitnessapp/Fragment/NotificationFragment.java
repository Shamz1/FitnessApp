package com.example.fitnessapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Adapter.NotificationAdapter;
import com.example.fitnessapp.Model.NotificationItem;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

// NotificationFragment.java
public class NotificationFragment extends Fragment {

    private RecyclerView notificationRecyclerView;
    private NotificationAdapter notificationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        // Initialize RecyclerView
        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView);

        // Set up RecyclerView with dummy data (replace with your data)
        setupRecyclerView();

        return view;
    }

    private void setupRecyclerView() {
        // Dummy data for notifications
        List<NotificationItem> notificationList = new ArrayList<>();
        notificationList.add(new NotificationItem("New Message", "John Doe sent you a message."));
        notificationList.add(new NotificationItem("Friend Request", "Alice Doe sent you a friend request."));

        // Set up Notification RecyclerView
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        notificationAdapter = new NotificationAdapter(notificationList);
        notificationRecyclerView.setAdapter(notificationAdapter);
    }
}
