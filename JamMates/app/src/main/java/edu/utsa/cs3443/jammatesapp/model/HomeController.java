package edu.utsa.cs3443.jammatesapp.model;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.jammatesapp.model.Album;
import edu.utsa.cs3443.jammatesapp.model.Artist;
import edu.utsa.cs3443.jammatesapp.model.Song;

public class HomeController {
    private final List<Artist> artists;

    public HomeController(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Artist> getAllArtists() {
        return artists;
    }

    /*
    public List<Album> getAllAlbums() {
        List<Album> result = new ArrayList<>();
        for (Artist artist : artists) result.addAll(artist.getAlbums());
        return result;
    }

     */

    public List<Song> getAllSongs() {
        List<Song> result = new ArrayList<>();
        for (Artist artist : artists) {
            result.addAll(artist.getSongList());
        };
        return result;
    }

    public void toggleFavorite(Object item) {
        if (item instanceof Artist) {
            Artist artist = (Artist) item;
            artist.setFavorite(!artist.isFavorite());
        } else if (item instanceof Album) {
            Album album = (Album) item;
            album.setFavorite(!album.isFavorite());
        } else if (item instanceof Song) {
            Song song = (Song) item;
            song.setFavorite(!song.isFavorite());
        }
    }

    public List<Object> getFavorites() {
        List<Object> favorites = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.isFavorite()) {
                favorites.add(artist);
            }
            for (Song song : artist.getSongList()) {
                if (song.isFavorite()) favorites.add(song);
            }
        }
        return favorites;
    }
}
