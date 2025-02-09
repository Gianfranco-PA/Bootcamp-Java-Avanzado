package com.example.refactor.service.playlist.spotify;

import com.example.refactor.service.playlist.spotify.dto.*;
import com.example.refactor.utils.files.JsonValidationUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotifyJsonParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyJsonParser.class);

    /**
     * Parses the JSON file and transforms it into a SpotifyPlaylistDTO object.
     *
     * @param jsonFile File with the JSON to parse.
     * @return SpotifyPlaylistDTO object representing the structure of the JSON.
     */
    public SpotifyPlaylistDTO parse(File jsonFile) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(jsonFile)) {
            JSONObject rootObject = (JSONObject) parser.parse(reader);
            
            // Validate and get the "items" array
            JSONArray itemsArray = JsonValidationUtils.getJSONArray(rootObject, "items", "SpotifyPlaylistDTO");
            
            SpotifyPlaylistDTO playlistDTO = new SpotifyPlaylistDTO();
            List<SpotifyPlaylistItemDTO> itemDTOList = new ArrayList<>();
            
            for (Object itemObj : itemsArray) {
                JSONObject itemJson = (JSONObject) itemObj;
                SpotifyPlaylistItemDTO itemDTO = parsePlaylistItem(itemJson);
                itemDTOList.add(itemDTO);
            }
            playlistDTO.setItems(itemDTOList);
            
            return playlistDTO;
        } catch (IOException | ParseException e) {
            LOGGER.error("Error parsing Spotify JSON file: {}", e.getMessage());
            throw new RuntimeException("Error parsing Spotify JSON file", e);
        }
    }

    /**
     * Parses each element of the "items" array and transforms it into a SpotifyPlaylistItemDTO.
     *
     * @param itemJson JSON object representing a playlist item.
     * @return SpotifyPlaylistItemDTO object.
     */
    private SpotifyPlaylistItemDTO parsePlaylistItem(JSONObject itemJson) {
        SpotifyPlaylistItemDTO itemDTO = new SpotifyPlaylistItemDTO();

        // Parse the user who added the song
        JSONObject addedByJson = (JSONObject) itemJson.get("added_by");
        String id = JsonValidationUtils.getString(addedByJson, "id", "SpotifyUserDTO");
        itemDTO.setAdded_by(id);

        // Parse the track information
        JSONObject trackJson = (JSONObject) itemJson.get("track");
        SpotifyTrackDTO trackDTO = parseSpotifyTrack(trackJson);
        itemDTO.setTrack(trackDTO);

        return itemDTO;
    }

    /**
     * Parses the JSON object corresponding to the track.
     *
     * @param trackJson JSON object of the track.
     * @return SpotifyTrackDTO object.
     */
    private SpotifyTrackDTO parseSpotifyTrack(JSONObject trackJson) {
        SpotifyTrackDTO trackDTO = new SpotifyTrackDTO();

        // Parse the album
        JSONObject albumJson = (JSONObject) trackJson.get("album");
        SpotifyAlbumDTO albumDTO = parseSpotifyAlbum(albumJson);
        trackDTO.setAlbum(albumDTO);

        // Parse the list of artists
        JSONArray artistsJsonArray = JsonValidationUtils.getJSONArray(trackJson, "artists", "SpotifyTrackDTO");
        List<SpotifyArtistDTO> artistsList = new ArrayList<>();
        for (Object artistObj : artistsJsonArray) {
            JSONObject artistJson = (JSONObject) artistObj;
            SpotifyArtistDTO artistDTO = parseSpotifyArtist(artistJson);
            artistsList.add(artistDTO);
        }
        trackDTO.setArtists(artistsList);

        // Parse simple attributes
        trackDTO.setExplicit(JsonValidationUtils.getBoolean(trackJson, "explicit", "SpotifyTrackDTO"));
        trackDTO.setId(JsonValidationUtils.getString(trackJson, "id", "SpotifyTrackDTO"));
        trackDTO.setIs_playable(JsonValidationUtils.getBoolean(trackJson, "is_playable", "SpotifyTrackDTO"));
        trackDTO.setName(JsonValidationUtils.getString(trackJson, "name", "SpotifyTrackDTO"));
        trackDTO.setPopularity(JsonValidationUtils.getInt(trackJson, "popularity", "SpotifyTrackDTO"));

        return trackDTO;
    }

    /**
     * Parses the JSON object corresponding to the album.
     *
     * @param albumJson JSON object of the album.
     * @return SpotifyAlbumDTO object.
     */
    private SpotifyAlbumDTO parseSpotifyAlbum(JSONObject albumJson) {
        SpotifyAlbumDTO albumDTO = new SpotifyAlbumDTO();
        albumDTO.setAlbum_type(JsonValidationUtils.getString(albumJson, "album_type", "SpotifyAlbumDTO"));
        albumDTO.setHref(JsonValidationUtils.getString(albumJson, "href", "SpotifyAlbumDTO"));
        albumDTO.setId(JsonValidationUtils.getString(albumJson, "id", "SpotifyAlbumDTO"));
        albumDTO.setName(JsonValidationUtils.getString(albumJson, "name", "SpotifyAlbumDTO"));
        albumDTO.setRelease_date(JsonValidationUtils.getString(albumJson, "release_date", "SpotifyAlbumDTO"));
        albumDTO.setTotal_tracks(JsonValidationUtils.getInt(albumJson, "total_tracks", "SpotifyAlbumDTO"));
        return albumDTO;
    }

    /**
     * Parses the JSON object corresponding to the artist.
     *
     * @param artistJson JSON object of the artist.
     * @return SpotifyArtistDTO object.
     */
    private SpotifyArtistDTO parseSpotifyArtist(JSONObject artistJson) {
        SpotifyArtistDTO artistDTO = new SpotifyArtistDTO();

        // external_urls is handled as a Map<String, String>
        JSONObject externalUrlsJson = (JSONObject) artistJson.get("external_urls");
        if (externalUrlsJson != null) {
            Map<String, String> externalUrls = new HashMap<>();
            for (Object key : externalUrlsJson.keySet()) {
                String k = (String) key;
                String v = (String) externalUrlsJson.get(k);
                externalUrls.put(k, v);
            }
            artistDTO.setExternal_urls(externalUrls);
        }

        artistDTO.setHref(JsonValidationUtils.getString(artistJson, "href", "SpotifyArtistDTO"));
        artistDTO.setId(JsonValidationUtils.getString(artistJson, "id", "SpotifyArtistDTO"));
        artistDTO.setName(JsonValidationUtils.getString(artistJson, "name", "SpotifyArtistDTO"));
        artistDTO.setType(JsonValidationUtils.getString(artistJson, "type", "SpotifyArtistDTO"));
        artistDTO.setUri(JsonValidationUtils.getString(artistJson, "uri", "SpotifyArtistDTO"));

        return artistDTO;
    }
}

