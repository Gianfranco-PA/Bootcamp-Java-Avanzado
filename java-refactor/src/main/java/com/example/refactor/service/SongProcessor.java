package com.example.refactor.service;

import com.example.refactor.domain.PlayList;
import com.example.refactor.domain.Song;
import com.example.refactor.service.playlist.IPlaylistService;
import com.example.refactor.service.playlist.PlaylistServiceFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SongProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongProcessor.class);

    public void processSongs() {
        IPlaylistService playlistService = PlaylistServiceFactory.getService();
        PlayList playlist = playlistService.getPlayList();
        List<Song> songs = playlist.getSongs();
        for (Song song : songs) {
            LOGGER.info("Song: {}", song);
        }
    }

}
