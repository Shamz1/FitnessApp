package com.example.fitnessapp.Model;

public class Event {
    private String title;
    private String description;
    private String startDate;
    private String startTime;
    private String endTime;

    public Event(String title, String description, String startDate, String startTime, String endTime) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
