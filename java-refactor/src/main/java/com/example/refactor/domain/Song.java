package com.example.refactor.domain;

import java.util.List;

public class Song {
    private String id;
    private String name;
    private String album;
    private List<String> artists;

    public Song() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public List<String> getArtists() {
        return artists;
    }
    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    
}
