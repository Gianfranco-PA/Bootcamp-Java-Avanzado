package com.example.refactor.display;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.refactor.domain.Playlist;

public class PlaylistDisplayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistDisplayer.class);
    private PlaylistDisplayStrategy strategy;

    public PlaylistDisplayer(PlaylistDisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PlaylistDisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void display(Playlist playlist) {
        if (playlist == null || playlist.getSongs() == null || playlist.getSongs().isEmpty()) {
            LOGGER.warn("The playlist has no songs");
            return;
        }
        int count = playlist.getSongs().size();
        LOGGER.info("Displaying playlist with {} songs", count);
        strategy.display(playlist);
        LOGGER.info("Finished displaying the playlist");
    }
}
