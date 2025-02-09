package com.example.refactor.service.playlist.spotify;

import com.example.refactor.service.playlist.spotify.dto.SpotifyPlaylistDTO;
import com.example.refactor.domain.PlayList;
import com.example.refactor.service.playlist.PlaylistServiceTemplate;
import com.example.refactor.utils.files.ResourceFileLoader;
import java.io.File;

public class SpotifyFilePlaylistService extends PlaylistServiceTemplate<File, SpotifyPlaylistDTO> {

    private final String filename;

    public SpotifyFilePlaylistService(String filename) {
        this.filename = filename;
    }

    @Override
    protected File retrieveRawData() {
        return ResourceFileLoader.getFileFromResources(filename);
    }

    @Override
    protected SpotifyPlaylistDTO parseRawData(File rawData) {
        SpotifyJsonParser parser = new SpotifyJsonParser();
        return parser.parse(rawData);
    }

    @Override
    protected PlayList mapDtoToDomain(SpotifyPlaylistDTO dto) {
        SpotifyPlaylistMapper mapper = new SpotifyPlaylistMapper();
        return mapper.map(dto);
    }
}

