package com.example.fitnessapp.Activty;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Adapter.ProgramsAdapter;
import com.example.fitnessapp.Model.Program;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class Programms extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView programsRecyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programms);

        // Initialize views
        toolbar = findViewById(R.id.programmes_toolbar);
        programsRecyclerView = findViewById(R.id.programsRecyclerView);
        searchView = findViewById(R.id.programmes_searchView);

        toolbar.setTitle("");

        // Set up the toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set up the programs list
        setupProgramsRecyclerView();

        // Set up the search functionality
        setupSearchView();
    }

    // Handle the back button click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Add your specific functionality here

    private void setupProgramsRecyclerView() {
        // Static data for RecyclerView
        List<Program> programList = generateStaticPrograms();

        // Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        programsRecyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        ProgramsAdapter adapter = new ProgramsAdapter(programList);
        programsRecyclerView.setAdapter(adapter);

        // Handle item click for program details
        adapter.setOnItemClickListener(position -> {
            Program selectedProgram = programList.get(position);
            Toast.makeText(this, "Clicked on program: " + selectedProgram.getTitle(), Toast.LENGTH_SHORT).show();

            // Implement logic for program details here
        });
    }

    // Method to generate static program data
    private List<Program> generateStaticPrograms() {
        List<Program> programList = new ArrayList<>();

        // Add static programs
        programList.add(new Program("Program 1", "Description 1"));
        programList.add(new Program("Program 2", "Description 2"));
        programList.add(new Program("Program 3", "Description 3"));

        return programList;
    }

    private void setupSearchView() {
        // Set a query listener for the search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the query submission if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle the query text change (filtering the list, for example)
                // For now, let's just show a toast with the current query
                Toast.makeText(Programms.this, "Search query: " + newText, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


}
