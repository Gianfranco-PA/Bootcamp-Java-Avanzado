package com.example.refactor.model;

public class Song {

    private String id;
    private String name;
    private Boolean explicit;
    private Boolean playable;
    private Integer popularity;

    private String albumId;
    private String albumType;
    private String albumName;
    private String albumReleaseDate;
    private Integer albumTotalTracks;

    public SpotifyArtist spotifyArtist;

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

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumReleaseDate() {
        return albumReleaseDate;
    }

    public void setAlbumReleaseDate(String albumReleaseDate) {
        this.albumReleaseDate = albumReleaseDate;
    }

    public Integer getAlbumTotalTracks() {
        return albumTotalTracks;
    }

    public void setAlbumTotalTracks(Integer albumTotalTracks) {
        this.albumTotalTracks = albumTotalTracks;
    }

    public SpotifyArtist getSpotifyArtist() {
        return spotifyArtist;
    }

    public void setSpotifyArtist(SpotifyArtist spotifyArtist) {
        this.spotifyArtist = spotifyArtist;
    }
}
