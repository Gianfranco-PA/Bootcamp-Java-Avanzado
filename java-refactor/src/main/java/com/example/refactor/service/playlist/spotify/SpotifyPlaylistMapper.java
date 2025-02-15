package com.example.refactor.service.playlist.spotify;

import com.example.refactor.service.playlist.spotify.dto.SpotifyPlaylistDTO;
import com.example.refactor.service.playlist.spotify.dto.SpotifyPlaylistItemDTO;
import com.example.refactor.service.playlist.spotify.dto.SpotifyTrackDTO;
import com.example.refactor.service.playlist.spotify.dto.SpotifyAlbumDTO;
import com.example.refactor.service.playlist.spotify.dto.SpotifyArtistDTO;
import com.example.refactor.domain.Playlist;
import com.example.refactor.domain.Song;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotifyPlaylistMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyPlaylistMapper.class);

    public Playlist map(SpotifyPlaylistDTO dto) {
        LOGGER.info("Starting the mapping of SpotifyPlaylistDTO to Playlist");
        Playlist playList = new Playlist();

        List<Song> songs = new ArrayList<>();
        
        if (dto != null && dto.getItems() != null) {
            for (SpotifyPlaylistItemDTO itemDTO : dto.getItems()) {
                SpotifyTrackDTO trackDTO = itemDTO.getTrack();
                if (trackDTO == null) {
                    LOGGER.warn("Found an item with null track, skipping");
                    continue;
                }
                
                Song song = new Song();
                song.setId(trackDTO.getId());
                song.setName(trackDTO.getName());

                SpotifyAlbumDTO albumDTO = trackDTO.getAlbum();
                if (albumDTO != null) {
                    song.setAlbum(albumDTO.getName());
                }
                
                List<SpotifyArtistDTO> artistDTOs = trackDTO.getArtists();
                if (artistDTOs != null) {
                    List<String> artists= new ArrayList<>(); 
                    for (SpotifyArtistDTO artistDTO : artistDTOs) {
                        artists.add(artistDTO.getName());
                    }
                    song.setArtists(artists);
                }
                songs.add(song);
            }
        }

        playList.setSongs(songs);
        LOGGER.info("Mapping completed. Total songs mapped: {}", songs.size());
        return playList;
    }
}

