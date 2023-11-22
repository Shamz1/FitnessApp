package com.example.fitnessapp.Adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Model.ChatRoom;
import com.example.fitnessapp.R;

import java.util.List;

// ChatRoomsAdapter.java
public class ChatRoomsAdapter extends RecyclerView.Adapter<ChatRoomsAdapter.ViewHolder> {
    private List<ChatRoom> chatRooms;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ChatRoom chatRoom);
    }

    public ChatRoomsAdapter(List<ChatRoom> chatRooms, OnItemClickListener onItemClickListener) {
        this.chatRooms = chatRooms;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_room_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatRoom chatRoom = chatRooms.get(position);
        holder.roomNameTextView.setText(chatRoom.getRoomName());
        holder.clientsTextView.setText(TextUtils.join(", ", chatRoom.getClients()));
        holder.visibilityTextView.setText(chatRoom.isPublic() ? "Public" : "Private");

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(chatRoom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatRooms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView roomNameTextView, clientsTextView, visibilityTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roomNameTextView = itemView.findViewById(R.id.roomNameTextView);
            clientsTextView = itemView.findViewById(R.id.clientsTextView);
            visibilityTextView = itemView.findViewById(R.id.visibilityTextView);
        }
    }
}
