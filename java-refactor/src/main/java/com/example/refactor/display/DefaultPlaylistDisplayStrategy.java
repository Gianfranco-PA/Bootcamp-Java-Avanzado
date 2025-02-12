package com.example.refactor.display;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.refactor.domain.Playlist;
import com.example.refactor.domain.Song;

public class DefaultPlaylistDisplayStrategy implements PlaylistDisplayStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPlaylistDisplayStrategy.class);

    @Override
    public void display(Playlist playlist) {
        LOGGER.info("=== Playlist ===");
        for (Song song : playlist.getSongs()) {
            String id = song.getId();
            String name = song.getName();
            String artists = String.join(", ", song.getArtists());
            String album = song.getAlbum();
            LOGGER.info("Song: {} - {} - {} - {}", id, name, artists, album);
        }
    }

}
