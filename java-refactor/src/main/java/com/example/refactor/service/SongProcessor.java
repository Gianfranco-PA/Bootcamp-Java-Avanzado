package com.example.refactor.service;

import com.example.refactor.model.Song;
import com.example.refactor.model.SpotifyArtist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedList;

public class SongProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongProcessor.class);

    public void processSongs() {
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");

        if (playlistFileName == null || playlistFileName.isEmpty()) {
            throw new IllegalArgumentException("Property 'refactorpractice.playlist.filename' is missing or empty");
        }

        final File inputSource = ExampleFileUtils.getFileFromResources(playlistFileName);
        if (!inputSource.exists() || !inputSource.canRead()) {
            throw new IllegalArgumentException("File '" + playlistFileName + "' not found or cannot be read");
        }

        final JSONObject playlist = ExampleFileUtils.getJsonFromFile(inputSource);
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist JSON is null");
        }

        final LinkedList<Song> spotifyPlayList = new LinkedList<>();

        if (!playlist.containsKey("items")) {
            throw new IllegalArgumentException("Playlist JSON does not contain 'items'");
        }
        final JSONArray items = (JSONArray) playlist.get("items");

        for (Object item : items) {
            JSONObject songJSON = (JSONObject) item;
            JSONObject trackJSON = (JSONObject) songJSON.get("track");
            JSONArray artistsJSON = (JSONArray) trackJSON.get("artists");
            JSONObject albumJSON = (JSONObject) trackJSON.get("album");

            Song song = new Song();
            song.setExplicit(getBoolean(trackJSON, "explicit"));
            song.setId(getString(trackJSON, "id"));
            song.setPlayable(getBoolean(trackJSON, "is_playable"));

            song.setName(getString(trackJSON, "name"));
            song.setPopularity(getInt(trackJSON, "popularity"));
            song.setAlbumType(getString(albumJSON, "album_type"));
            song.setAlbumId(getString(albumJSON, "id"));
            song.setAlbumName(getString(albumJSON, "name"));
            song.setAlbumReleaseDate(getString(albumJSON, "release_date"));
            song.setAlbumTotalTracks(getInt(albumJSON, "total_tracks"));

            for (Object element : artistsJSON) {
                JSONObject artistJSON = (JSONObject) element;

                SpotifyArtist artist = new SpotifyArtist();
                artist.setId(getString(artistJSON, "id"));
                artist.setName(getString(artistJSON, "name"));
                song.setSpotifyArtist(artist);
            }

            spotifyPlayList.add(song);
        }

        for (Song song : spotifyPlayList) {
            LOGGER.info(" - {} - {} - {} - {}", song.getId(), song.getName(),
                                                song.getSpotifyArtist().getName(), song.getAlbumName());
        }
    }

    private String getString(JSONObject json, String key) {
        if (!json.containsKey(key) || json.get(key) == null) {
            throw new IllegalArgumentException("Missing or null key: " + key);
        }
        return json.get(key).toString();
    }

    private int getInt(JSONObject json, String key) {
        if (!json.containsKey(key) || json.get(key) == null) {
            throw new IllegalArgumentException("Missing or null key: " + key);
        }
        return ((Number) json.get(key)).intValue();
    }

    private boolean getBoolean(JSONObject json, String key) {
        if (!json.containsKey(key) || json.get(key) == null) {
            throw new IllegalArgumentException("Missing or null key: " + key);
        }
        return ((Boolean) json.get(key));
    }

}
