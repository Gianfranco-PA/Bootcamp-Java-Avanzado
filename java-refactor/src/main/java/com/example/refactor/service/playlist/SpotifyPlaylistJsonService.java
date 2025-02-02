package com.example.refactor.service.playlist;

import com.example.refactor.model.PlayList;
import com.example.refactor.service.config.ConfigManager;

public class SpotifyPlaylistJsonService implements IPlaylistService{

    private final String filename;

    public SpotifyPlaylistJsonService() {
        ConfigManager config = ConfigManager.getInstance();
        this.filename = config.getProperty("spotify.playlist.json.filename");
    }

    @Override
    public PlayList getPlayList() {
        // TODO Auto-generated method stub
        return null;
    }
}
