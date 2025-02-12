package com.example.refactor.service.playlist.spotify.dto;

import java.util.List;

public class SpotifyTrackDTO {
    private SpotifyAlbumDTO album;
    private List<SpotifyArtistDTO> artists;
    private Boolean explicit;
    private String id;
    private Boolean is_playable;
    private String name;
    private int popularity;

    public SpotifyAlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(SpotifyAlbumDTO album) {
        this.album = album;
    }

    public List<SpotifyArtistDTO> getArtists() {
        return artists;
    }

    public void setArtists(List<SpotifyArtistDTO> artists) {
        this.artists = artists;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIs_playable() {
        return is_playable;
    }

    public void setIs_playable(Boolean is_playable) {
        this.is_playable = is_playable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}

