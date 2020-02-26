package com.company.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Album implements Serializable, MusicObject {

    private String name;
    private Artist artist;
    private List<Song> songs = new ArrayList<>();

    public Album(){}

    public Album(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(Song song) {
        songs.add(song);
        song.setAlbum(this);
    }

    @Override
    public String toString() {
        return "Album: " + name + songs.toString();
    }
}
