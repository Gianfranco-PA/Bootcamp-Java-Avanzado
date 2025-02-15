package com.example.refactor.service.playlist.spotify.dto;

public record SpotifyAlbumDTO (
    String album_type,
    String href,
    String id,
    String name,
    String release_date,
    int total_tracks
) {}