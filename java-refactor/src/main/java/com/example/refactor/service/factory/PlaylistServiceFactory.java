package com.example.refactor.service.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.refactor.config.ConfigManager;
import com.example.refactor.service.playlist.base.IPlaylistService;
import com.example.refactor.service.playlist.spotify.SpotifyFilePlaylistService;

public class PlaylistServiceFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistServiceFactory.class);

    public static IPlaylistService getService() {
        ConfigManager config = ConfigManager.getInstance();
        String serviceType = config.getProperty("service.type");
        LOGGER.info("Selected service: {}", serviceType);

        var service = switch (serviceType.toLowerCase()) {
            case "spotify-json" -> {
                String filename = config.getProperty("spotify.playlist.json.filename");
                LOGGER.info("Using SpotifyFilePlaylistService with the file: {}", filename);
                yield new SpotifyFilePlaylistService(filename);
            }

            default -> {
                LOGGER.error("Service not supported: {}", serviceType);
                throw new IllegalArgumentException("Servicio no soportado: " + serviceType);
            }
        };

        return service;
    }
}
