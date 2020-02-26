package com.company.pojo;

import java.io.Serializable;

public class Song implements Serializable, MusicObject {
    private String name;
    private Artist artist;
    private Album album;

    public Song() {
    }

    public Song(String name) {
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Title: " + name;
    }
}