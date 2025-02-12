package com.example.refactor.facade;

import com.example.refactor.display.PlaylistDisplayStrategy;
import com.example.refactor.display.PlaylistDisplayer;
import com.example.refactor.domain.Playlist;
import com.example.refactor.service.factory.PlaylistServiceFactory;
import com.example.refactor.service.playlist.base.IPlaylistService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaylistFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistFacade.class);
    private PlaylistDisplayStrategy displayStrategy;

    public PlaylistFacade(PlaylistDisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    public void showPlaylist() {
        try {
            IPlaylistService playlistService = PlaylistServiceFactory.getService();
            Playlist playlist = playlistService.getPlayList();

            PlaylistDisplayer displayer = new PlaylistDisplayer(displayStrategy);
            displayer.display(playlist);
        } catch (Exception e) {
            LOGGER.error("Error displaying the playlist: {}", e.getMessage(), e);
        }
    }
    
    public void setDisplayStrategy(PlaylistDisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }
}
