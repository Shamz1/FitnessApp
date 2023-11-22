package com.example.fitnessapp.Activty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Adapter.ClassesAdapter;
import com.example.fitnessapp.Model.ClassModel;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class ClassesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SearchView searchView;
    private RecyclerView classesRecyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasess);

        // Initialize views
        toolbar = findViewById(R.id.class_toolbar);
        searchView = findViewById(R.id.class_searchView);
        classesRecyclerView1 = findViewById(R.id.classesRecyclerView);

        toolbar.setTitle("");

        // Set up the toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set up RecyclerView for classes
        setupClassesRecyclerView();
    }

    // Handle the back button click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Add your specific functionality here

    private void setupClassesRecyclerView() {
        // Static data for RecyclerView
        List<ClassModel> classList = generateStaticClasses();

        // Set up RecyclerView
        ClassesAdapter adapter = new ClassesAdapter(classList);

        // Use LinearLayoutManager to set the orientation of the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        classesRecyclerView1.setLayoutManager(layoutManager);

        // Set the adapter for the RecyclerView
        classesRecyclerView1.setAdapter(adapter);

        // Search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


    // Method to generate static class data
    private List<ClassModel> generateStaticClasses() {
        List<ClassModel> classList = new ArrayList<>();

        // Add static classes
        classList.add(new ClassModel("Class 1", "Description 1"));
        classList.add(new ClassModel("Class 2", "Description 2"));
        classList.add(new ClassModel("Class 3", "Description 3"));

        return classList;
    }
}
