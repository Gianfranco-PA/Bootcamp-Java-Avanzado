package com.example.refactor.service.playlist.spotify.dto;

import java.util.Map;

public record SpotifyArtistDTO (
    Map<String, String> external_urls,
    String href,
    String id,
    String name,
    String type,
    String uri
) {}

