package com.company.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Artist implements Serializable, MusicObject{

    private static int id;
    private int artistID;
    private String name;
    private List<Album> albums = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
        this.artistID = id++;
    }

    public Artist(Artist artist){
        this.artistID = artist.getArtistID();
        this.name = artist.getName();
        this.albums = artist.getAlbums();
        this.songs = artist.getSongs();
        id++;
    }

    public int getArtistID() {
        return artistID;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
        album.setArtist(this);
    }

    public void addAlbums(List<Album> albums){
        for (Album album: albums){
            addAlbum(album);
        }
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
        song.setArtist(this);
    }
    public void addSongs(List<Song> songs){
        for (Song song: songs){
            addSong(song);
        }
    }

    @Override
    public String toString() {
        return "Artist: " + name +
                ", albums:" + albums.toString();
    }
}