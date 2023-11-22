package com.example.fitnessapp.Activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fitnessapp.Adapter.EventsAdapter;
import com.example.fitnessapp.Model.Event;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CalendarView calendarView;
    private LinearLayout trainerAvailabilityLayout;
    private RecyclerView eventsRecyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        // Initialize views
        toolbar = findViewById(R.id.calender_toolbar);
        calendarView = findViewById(R.id.calendarView);
        trainerAvailabilityLayout = findViewById(R.id.trainerAvailabilityLayout);
        eventsRecyclerView = findViewById(R.id.eventsRecyclerView);
        searchView = findViewById(R.id.calender_searchView);

        toolbar.setTitle("");

        // Set up the toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set up the calendar
        setupCalendar();

        // Set up trainer availability controls
        setupTrainerAvailabilityControls();

        // Set up RecyclerView for events/classes
        setupEventsRecyclerView();

        // Set up SearchView
        setupSearchView();
    }

    // Handle the back button click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Add your specific functionality here

    private void setupCalendar() {
        // For now, let's just show a toast when a date is selected
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(this, "Selected date: " + selectedDate, Toast.LENGTH_SHORT).show();
        });
    }

    private void setupTrainerAvailabilityControls() {
        // For now, let's just show a toast when a trainer adds availability
        trainerAvailabilityLayout.setOnClickListener(v -> Toast.makeText(this, "Trainer added availability", Toast.LENGTH_SHORT).show());
    }

    private void setupEventsRecyclerView() {
        // Static data for RecyclerView
        List<Event> eventList = generateStaticEvents();

        // Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        eventsRecyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        EventsAdapter adapter = new EventsAdapter(eventList);
        eventsRecyclerView.setAdapter(adapter);


        // Handle edit and delete clicks
        adapter.setOnItemClickListener(new EventsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click (view details) if needed
                Event selectedEvent = eventList.get(position);
                Toast.makeText(CalendarActivity.this, "Clicked on event: " + selectedEvent.getTitle(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onEditClick(int position) {
                Event editedEvent = eventList.get(position);
                handleEditDeleteEvent(editedEvent);
            }

            @Override
            public void onDeleteClick(int position) {
                Event deletedEvent = eventList.get(position);
                handleEditDeleteEvent(deletedEvent);
            }
        });

        // Handle add new event click
        findViewById(R.id.addEventButton).setOnClickListener(v -> addNewEvent());
    }

    private void setupSearchView() {
        // Set up a listener to respond to search events
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the search query submission (e.g., perform search)
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle the text change in the search bar (e.g., update suggestions)
                updateSearchSuggestions(newText);
                return true;
            }
        });
    }

    private void performSearch(String query) {
        // Implement search functionality based on the query
        // You may update your RecyclerView with search results
        // For now, let's just show a toast
        Toast.makeText(this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
    }

    private void updateSearchSuggestions(String newText) {
        // Implement logic to update search suggestions
        // For now, you might want to show suggestions in a dropdown or update the search results dynamically
    }

    // Method to generate static event data
    private List<Event> generateStaticEvents() {
        List<Event> eventList = new ArrayList<>();

        // Add static events
        eventList.add(new Event("Event 1", "Description 1", "2023-11-01", "10:00 AM", "11:30 AM"));
        eventList.add(new Event("Event 2", "Description 2", "2023-11-02", "02:00 PM", "03:30 PM"));
        eventList.add(new Event("Event 3", "Description 3", "2023-11-03", "04:00 PM", "05:30 PM"));

        return eventList;
    }


    private void handleEditDeleteEvent(Event event) {
        // For simplicity, show a toast; in a real app, you would implement edit/delete logic
        Toast.makeText(this, "Edit/Delete clicked for: " + event.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void addNewEvent() {
        // For simplicity, show a toast; in a real app, you would implement logic to add a new event
        Toast.makeText(this, "Add New Event clicked", Toast.LENGTH_SHORT).show();

    }
}
