package com.example.fitnessapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Adapter.ChatRoomsAdapter;
import com.example.fitnessapp.Activty.ChatRoomActivity;
import com.example.fitnessapp.Model.ChatRoom;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView chatRoomsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        // Initialize views
        chatRoomsRecyclerView = view.findViewById(R.id.chatRoomsRecyclerView);

        // Set up RecyclerView for chat rooms
        setupChatRoomsRecyclerView();

        return view;
    }

    private void setupChatRoomsRecyclerView() {
        // Static data for RecyclerView
        List<ChatRoom> chatRooms = generateStaticChatRooms();

        // Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        chatRoomsRecyclerView.setLayoutManager(layoutManager);
        ChatRoomsAdapter adapter = new ChatRoomsAdapter(chatRooms, chatRoom -> {
            // Handle item click, e.g., open the selected chat room
            openChatRoom(chatRoom);
        });

        chatRoomsRecyclerView.setAdapter(adapter);


    }

    // Method to generate static chat room data
    private List<ChatRoom> generateStaticChatRooms() {
        List<ChatRoom> chatRooms = new ArrayList<>();

        // Add static chat rooms
        chatRooms.add(new ChatRoom("Room 1", Arrays.asList("User1", "User2"), true));
        chatRooms.add(new ChatRoom("Room 2", Arrays.asList("User3", "User4"), false));
        chatRooms.add(new ChatRoom("Room 3", Arrays.asList("User5", "User6"), true));

        return chatRooms;
    }

    private void openChatRoom(ChatRoom chatRoom) {
        // Launch ChatRoomActivity with the selected chat room details
        Intent intent = new Intent(requireContext(), ChatRoomActivity.class);
        Bundle b = new Bundle();
        b.putString("chatRoomTitle", chatRoom.getRoomName());
        intent.putExtras(b);
        startActivity(intent);
    }

}

