package com.company;

import com.company.Menu.Menu;
import com.company.pojo.Album;
import com.company.pojo.Artist;
import com.company.pojo.MusicObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static List<Artist> artists = new ArrayList<>();

    public App() throws IOException {
        Database.getInstance().createDb("MusicDB");
        loadDatabase();
        Menu.getInstance().showMainMenu();
    }

    private static void printList() {
        for (Artist artist: artists){
            System.out.printf("ArtistID: %s, Artist: %s, Albums: %s, Songs: %s\n"
                    , artist.getArtistID()
                    , artist.getName()
                    , artist.getAlbums()
                    , artist.getSongs());
        }
    }

    public static List<MusicObject> searchByName(SearchOption searchOption) {
        List<MusicObject> results = new ArrayList<>();
        if(searchOption == SearchOption.ARTIST) {
            results = Search.searchByArtist(artists);
        } else if(searchOption == SearchOption.ALBUM){
            results = Search.searchByAlbum(artists);
        } else if(searchOption == SearchOption.SONG){
            results = Search.searchBySong(artists);
        }
        return results;
    }

    private void loadDatabase() {
        List<String> filePaths = Database.getInstance().getDbFiles();
        if(filePaths.size() > 0) {
            for (String filePath : filePaths) {
                Artist load = (Artist) Database.getInstance().readDbFile(filePath);
                Artist toAdd = new Artist(load);
                artists.add(toAdd);
            }
        }
    }

    /*public static void addAlbum() {
        System.out.print("Enter Album title to add> ");
        String albumToAdd = Input.getLine(true);

        System.out.print("Enter Artist to add Album to> ");
        List<MusicObject> results = searchByName(SearchOption.ARTIST);
        Search.showResults(results, true);
        System.out.print("Enter index of Artist or [" + (results.size() + 1) + "] to create new Artist> ");

        int index = Input.getInt();

        if(index == results.size()+1){
            addArtist();
            artists.get(artists.size()-1).addAlbum(new Album(albumToAdd));
        }

    }*/

    /*public static void addArtist() {
        System.out.print("Enter Artist name to add> ");
        String artistToAdd = Input.getLine(true);
        boolean checkExistingArtist = false;

        for (Artist artist : artists){
            String nameCompare = artist.getName();
            if(artistToAdd.equals(nameCompare)){

                checkExistingArtist = true;
                System.out.println("Artist already exists!");
            }
        }
        if(!checkExistingArtist){
            Artist addArtist = new Artist(artistToAdd);
            artists.add(addArtist);
            Database.getInstance().writeToFile(addArtist);
        }
    }*/
}
