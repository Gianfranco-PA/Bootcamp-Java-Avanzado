package com.example.refactor.model;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private String id;
    private String name;
    private Boolean explicit;
    private Boolean playable;
    private Integer popularity;

    // All the following attributes are moved to the Album class
    /*
     * private String albumId;
     * private String albumType;
     * private String albumName;
     * private String albumReleaseDate;
     * private Integer albumTotalTracks;
     */

    private List<Artist> artists;
    private Album album;

    public Song() {
        this.artists = new ArrayList<>();
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

    public Boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public Boolean isPlayable() {
        return playable;
    }

    public void setPlayable(Boolean playable) {
        this.playable = playable;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    // All the following getters and setters are moved to the Album class
    /*
     * public String getAlbumId() {
     * return albumId;
     * }
     * 
     * public void setAlbumId(String albumId) {
     * this.albumId = albumId;
     * }
     * 
     * public String getAlbumType() {
     * return albumType;
     * }
     * 
     * public void setAlbumType(String albumType) {
     * this.albumType = albumType;
     * }
     * 
     * public String getAlbumName() {
     * return albumName;
     * }
     * 
     * public void setAlbumName(String albumName) {
     * this.albumName = albumName;
     * }
     * 
     * public String getAlbumReleaseDate() {
     * return albumReleaseDate;
     * }
     * 
     * public void setAlbumReleaseDate(String albumReleaseDate) {
     * this.albumReleaseDate = albumReleaseDate;
     * }
     * 
     * public Integer getAlbumTotalTracks() {
     * return albumTotalTracks;
     * }
     * 
     * public void setAlbumTotalTracks(Integer albumTotalTracks) {
     * this.albumTotalTracks = albumTotalTracks;
     * }
     * 
     */

    public List<Artist> getArtist() {
        return artists;
    }

    public void setArtist(List<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public void removeArtist(Artist artist) {
        this.artists.remove(artist);
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String toString() {
        String songId = this.id;
        String songName = this.name;
        String albumName = this.album.getName();

        // We should iterate over the artists list to get all the artist names as String
        String artistNames = "";
        for (Artist artist : this.artists) {
            artistNames += artist.getName() + ", ";
        }
        artistNames = artistNames.substring(0, artistNames.length() - 2);
        artistNames = "[" + artistNames + "]";

        return String.format("%s - %s - %s - %s", songId, songName, artistNames, albumName);
    }
}
