package edu.utsa.cs3443.jammatesapp.model;



import java.io.*;
import java.util.*;
import android.content.Context;
import android.util.Log;


import edu.utsa.cs3443.jammatesapp.model.Album;
import edu.utsa.cs3443.jammatesapp.model.Artist;
import edu.utsa.cs3443.jammatesapp.model.Song;

public class ExploreController {

    private List<Artist> allArtists;

    public ExploreController(List<Artist> artists) {
        this.allArtists = artists;
    }
    public ExploreController(){
        this.allArtists = null;
    }

    public List<Artist> searchByName(String query) {
        List<Artist> result = new ArrayList<>();
        if (allArtists == null) {
            return result;
        }

        for (Artist artist : allArtists) {
            if (artist.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(artist);
            }
        }
        return result;
    }

    public List<Artist> searchByGenre(String genre) {
        List<Artist> result = new ArrayList<>();
        for (Artist artist : allArtists) {
            if (artist.getGenre().equalsIgnoreCase(genre)) {
                result.add(artist);
            }
        }
        return result;
    }

    public List<Song> searchSongs(String query) {
        List<Song> result = new ArrayList<>();
        for (Artist artist : allArtists) {
            for (Song song : artist.getSongList()) {
                if (song.getTitle().toLowerCase().contains(query.toLowerCase())) {
                    result.add(song);
                }
            }
        }
        return result;
    }

    public List<Artist> loadArtists(Context context, String filename) {
        List<Artist> artistList = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            Map<String, Artist> artistMap = new HashMap<>();

            // Skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // Allow empty values
                if (parts.length < 3) continue;

                String artistName = parts[0].trim();
                String artistGenre = parts[1].trim();
                String songTitle = parts[2].trim();

                if (artistList == null) {
                    Log.e("LOAD_ARTISTS", "artistList is null!");
                }
                Artist artist = artistMap.get(artistName);
                if (artist == null) {
                    artist = new Artist(artistName, artistGenre);
                    artistMap.put(artistName, artist);
                    try {
                        artistList.add(artist);
                        Log.d("LOAD_ARTISTS", "Artist added to list: " + artistName);
                    } catch (Exception e) {
                        Log.e("LOAD_ARTISTS", "Failed to add artist to list: " + artistName + " | genre: " + artistGenre, e);
                    }

                    //Log.d("LOAD_ARTISTS", "Adding artist: " + artist.getName());

                }
                try {
                    artist.addSong(songTitle);
                } catch (Exception e) {
                    Log.e("LOAD_ERROR", "Failed to add song: " + songTitle + " to artist: " + artist.getName(), e);
                }

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("CSV", "Error reading file: " + e.getMessage());
        }

        allArtists = artistList;
        return artistList;
    }


}
