package com.example.refactor.service.playlist.spotify.dto;

public record SpotifyPlaylistItemDTO (
    String added_by,
    SpotifyTrackDTO track
) {}
