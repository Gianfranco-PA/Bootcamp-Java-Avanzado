package com.example.refactor.service.playlist;

import java.io.File;

import com.example.refactor.config.ConfigManager;
import com.example.refactor.domain.PlayList;
import com.example.refactor.utils.files.FileParserFactory;
import com.example.refactor.utils.files.IFileParser;
import com.example.refactor.utils.files.ResourceFileLoader;

public class SpotifyPlaylistJsonService implements IPlaylistService{

    private final String filename;

    public SpotifyPlaylistJsonService() {
        ConfigManager config = ConfigManager.getInstance();
        this.filename = config.getProperty("spotify.playlist.json.filename");
    }

    @Override
    public PlayList getPlayList() {
        File JsonFile = ResourceFileLoader.getFileFromResources(this.filename);
        IFileParser parser = FileParserFactory.getParser("json");
        PlayList playlist = parser.extracPlayList(JsonFile);
        return playlist;
    }
}
