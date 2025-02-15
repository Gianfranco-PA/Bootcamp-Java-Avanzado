package com.example.refactor.service.playlist.spotify.dto;

import java.util.List;

public record SpotifyPlaylistDTO (
    List<SpotifyPlaylistItemDTO> items
) {}
