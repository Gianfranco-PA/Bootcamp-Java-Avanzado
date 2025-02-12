package com.example.refactor.service.playlist.spotify.dto;

public class SpotifyPlaylistItemDTO {
    private String added_by;
    private SpotifyTrackDTO track;

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public SpotifyTrackDTO getTrack() {
        return track;
    }

    public void setTrack(SpotifyTrackDTO track) {
        this.track = track;
    }
}
