package com.example.fitnessapp.Activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnessapp.Adapter.ChatMessagesAdapter;
import com.example.fitnessapp.Model.ChatMessage;
import com.example.fitnessapp.Model.ChatRoom;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// ChatRoomActivity.java
public class ChatRoomActivity extends AppCompatActivity {
    private List<ChatMessage> chatMessages;
    private ChatMessagesAdapter adapter;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        // Initialize views
        RecyclerView messagesRecyclerView = findViewById(R.id.messagesRecyclerView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        // Initialize the chat messages list (static data for now)
        chatMessages = generateStaticChatMessages();

        // Set up RecyclerView for messages
        adapter = new ChatMessagesAdapter(chatMessages);
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        messagesRecyclerView.setAdapter(adapter);
        Toolbar toolbar = findViewById(R.id.chatroom_toolbar);
        TextView textView = findViewById(R.id.chatroom_toolbarTitle);

        // Retrieve the selected chat room title from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            textView.setText(extras.getString("chatRoomTitle"));
        }
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // Set up click listener for the send button
        sendButton.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        // Get the message from the EditText
        String message = messageEditText.getText().toString().trim();

        if (!message.isEmpty()) {
            // Create a new ChatMessage object and add it to the list
            ChatMessage newMessage = new ChatMessage("User", message, new Date());
            chatMessages.add(newMessage);

            // Notify the adapter that the data set has changed
            adapter.notifyDataSetChanged();

            // Clear the EditText
            messageEditText.getText().clear();
        }
    }

    private List<ChatMessage> generateStaticChatMessages() {
        List<ChatMessage> messages = new ArrayList<>();

        // Add static chat messages
        messages.add(new ChatMessage("User1", "Hello!", new Date()));
        messages.add(new ChatMessage("User2", "Hi there!", new Date()));
        messages.add(new ChatMessage("User1", "How are you?", new Date()));
        messages.add(new ChatMessage("User2", "I'm good, thanks!", new Date()));

        return messages;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
