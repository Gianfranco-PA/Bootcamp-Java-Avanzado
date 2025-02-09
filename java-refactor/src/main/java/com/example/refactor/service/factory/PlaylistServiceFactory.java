package com.example.refactor.service.factory;

import com.example.refactor.config.ConfigManager;
import com.example.refactor.service.playlist.IPlaylistService;
import com.example.refactor.service.playlist.spotify.SpotifyFilePlaylistService;

public class PlaylistServiceFactory {
     public static IPlaylistService getService() {
        ConfigManager config = ConfigManager.getInstance();
        String serviceType = config.getProperty("service.type");

        switch (serviceType.toLowerCase()) {
            case "spotify-json":
                String filename = config.getProperty("spotify.playlist.json.filename");
                return new SpotifyFilePlaylistService(filename);
            default:    
                throw new IllegalArgumentException("Servicio no soportado: " + serviceType);
        }
    }
}
