package com.example.refactor.service.playlist.spotify.dto;

import java.util.List;

public record SpotifyTrackDTO (
    SpotifyAlbumDTO album,
    List<SpotifyArtistDTO> artists,
    Boolean explicit,
    String id,
    Boolean is_playable,
    String name,
    int popularity
) {}

