package com.example.fitnessapp.Model;

public class ClassModel {
    private String title;
    private String description;

    public ClassModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
