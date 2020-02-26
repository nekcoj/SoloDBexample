package com.company;

import com.company.pojo.Album;
import com.company.pojo.Artist;
import com.company.pojo.MusicObject;
import com.company.pojo.Song;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static List<MusicObject> searchByArtist(List<Artist> artists) {
        String search = Input.getLine(true);
        List<MusicObject> results = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.getName().toLowerCase().contains(search.toLowerCase())) {
                results.add(artist);
            }
        }
        return results;
    }

    public static void showResults(List<MusicObject> results, boolean index) {
        if (results.size() > 0) {
            System.out.println("Results found:");
            if (index) {
                for (int i = 0; i < results.size(); i++) {
                    System.out.printf("[%s]: %s\n", i + 1, results.get(i).getName());
                }
            } else {
                for (MusicObject result : results) {
                    System.out.printf("%s\n", result.getName());
                }
            }
        } else{
            System.out.println("No results found!");
        }
    }

    public static List<MusicObject> searchByAlbum(List<Artist> artists) {
        String search = Input.getLine(true);
        List<MusicObject> results = new ArrayList<>();
        List<Album> albums;
        for (Artist artist : artists) {
            albums = artist.getAlbums();
            for (Album album : albums)
                if (album.getName().toLowerCase().contains(search.toLowerCase())) {
                    results.add(album);
                }
        }
        return results;
    }

    public static List<MusicObject> searchBySong(List<Artist> artists) {
        String search = Input.getLine(true);
        List<MusicObject> results = new ArrayList<>();
        List<Song> songs;
        for (Artist artist : artists) {
            songs = artist.getSongs();
            for (Song song : songs)
                if (song.getName().toLowerCase().contains(search.toLowerCase())) {
                    results.add(artist);
                }
        }
        return results;
    }
}
