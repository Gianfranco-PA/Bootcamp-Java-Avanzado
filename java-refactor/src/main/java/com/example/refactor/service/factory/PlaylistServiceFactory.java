package com.example.refactor.service.factory;

import com.example.refactor.config.ConfigManager;
import com.example.refactor.service.playlist.IPlaylistService;
import com.example.refactor.service.playlist.spotify.SpotifyPlaylistJsonService;

public class PlaylistServiceFactory {
     public static IPlaylistService getService() {
        ConfigManager config = ConfigManager.getInstance();
        String serviceType = config.getProperty("service.type");

        switch (serviceType.toLowerCase()) {
            case "spotify-json":
                return new SpotifyPlaylistJsonService();
            default:    
                throw new IllegalArgumentException("Servicio no soportado: " + serviceType);
        }
    }
}
