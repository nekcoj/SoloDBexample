package com.company;

import com.company.pojo.Album;
import com.company.pojo.Artist;
import com.company.pojo.MusicObject;

import java.util.List;

public class Add {

    public static void addAlbum(List<Artist> artists) {
        System.out.print("Enter Album title to add> ");
        String albumToAdd = Input.getLine(true);

        System.out.print("Enter Artist to add Album to> ");
        List<MusicObject> results = App.searchByName(SearchOption.ARTIST);
        Search.showResults(results, true);
        System.out.print("Enter index of Artist or [" + (results.size() + 1) + "] to create new Artist> ");

        int index = Input.getInt();

        if(index == results.size()+1){
            addArtist(artists);
            artists.get(artists.size()-1).addAlbum(new Album(albumToAdd));
        }

    }

    public static void addArtist(List<Artist> artists) {
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
    }
}
