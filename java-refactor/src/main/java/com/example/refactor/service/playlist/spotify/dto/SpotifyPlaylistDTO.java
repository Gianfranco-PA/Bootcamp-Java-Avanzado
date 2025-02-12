package com.example.refactor.service.playlist.spotify.dto;

import java.util.List;

public class SpotifyPlaylistDTO {
    private List<SpotifyPlaylistItemDTO> items;

    public List<SpotifyPlaylistItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SpotifyPlaylistItemDTO> items) {
        this.items = items;
    }
}
