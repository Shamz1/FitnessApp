package com.example.fitnessapp.Model;

import java.io.Serializable;
import java.util.List;

// ChatRoom.java
public class ChatRoom implements Serializable {
    private String roomName;
    private List<String> clients;  // Corrected to use List<String>
    private boolean isPublic;

    // Constructor, getters, and setters

    public ChatRoom(String roomName, List<String> clients, boolean isPublic) {
        this.roomName = roomName;
        this.clients = clients;
        this.isPublic = isPublic;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<String> getClients() {
        return clients;
    }

    public void setClients(List<String> clients) {
        this.clients = clients;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
