package com.example.refactor.model;

public class SpotifyArtist {
    private String id;
    private String name;
    //Not used and not needed
    //private LinkedList<SpotifyArtist> genres = new LinkedList<>();

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

    /*
    public LinkedList<?> getGenres() {
        return genres;
    }

    public void setGenres(LinkedList<SpotifyArtist> genres) {
        this.genres = genres;
    }¨
    */
}