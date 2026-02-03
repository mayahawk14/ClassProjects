package edu.utsa.cs3443.jammatesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.jammatesapp.model.ExploreController;
import edu.utsa.cs3443.jammatesapp.model.Artist;
import edu.utsa.cs3443.jammatesapp.model.Song;

/**
 * @author Alexa Rodriguez
 * class that does the explorer page, which has a search to categorize the artists and sogs
 */

public class ExploreActivity extends AppCompatActivity {

    private ExploreController exploreController;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private Spinner filterSpinner;
    private ExploreAdapter adapter;

    private List<Artist> allArtists;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.explore_filters,  // This should be in your `res/values/strings.xml`
                android.R.layout.simple_spinner_item
        );

        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.recyclerView);

        filterSpinner = findViewById(R.id.spinnerFilter); // Genre, Song, Artist
        if (filterSpinner == null) {
            Log.e("ExploreActivity", "Spinner is null!");
        } else {
            Log.d("ExploreActivity", "Spinner found!");
        }

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerAdapter);

        ExploreController controller = new ExploreController();
        List<Artist> artists = controller.loadArtists(this, "artistData.csv");

        exploreController = controller;
        allArtists = artists; // <-- Save for future filtering/searching

// Initialize RecyclerView and adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExploreAdapter(artists); // <- Initialize with full list
        recyclerView.setAdapter(adapter);




        // Handle search input
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                performSearch(newText);
                return true;
            }
        });

        // Handle filter changes
        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                performSearch(searchView.getQuery().toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button backButton = findViewById(R.id.explorerBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("BUTTON","Button was clicked!");
                Intent intent = new Intent(ExploreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void performSearch(String query) {
        Object selected = filterSpinner.getSelectedItem();

        if (selected == null) {
            Log.e("performSearch", "Filter spinner returned null");
            Intent intent = new Intent(ExploreActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            String filter = selected.toString();

            if (filter.equals("Artist")) {
                List<Artist> results = exploreController.searchByName(query);
                adapter.setArtistResults(results);
            } else if (filter.equals("Genre")) {
                List<Artist> results = exploreController.searchByGenre(query);
                adapter.setArtistResults(results);
            } else if (filter.equals("Song")) {
                List<Song> results = exploreController.searchSongs(query);
                adapter.setSongResults(results);
            }
        }

    }


}
