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
        LOGGER.info("Starting to parse the JSON file: {}", jsonFile.getName());
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(jsonFile)) {
            JSONObject rootObject = (JSONObject) parser.parse(reader);
            
            // Validate and get the "items" array
            JSONArray itemsArray = JsonValidationUtils.getJSONArray(rootObject, "items", "SpotifyPlaylistDTO");
            LOGGER.info("Found {} items in the JSON", itemsArray.size());
            List<SpotifyPlaylistItemDTO> itemDTOList = new ArrayList<>();
            
            for (Object itemObj : itemsArray) {
                JSONObject itemJson = (JSONObject) itemObj;
                SpotifyPlaylistItemDTO itemDTO = parsePlaylistItem(itemJson);
                itemDTOList.add(itemDTO);
            }
            SpotifyPlaylistDTO playlistDTO = new SpotifyPlaylistDTO(itemDTOList);
            LOGGER.info("Finished parsing the JSON file: {}", jsonFile.getName());
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
        // Parse the user who added the song
        JSONObject addedByJson = (JSONObject) itemJson.get("added_by");
        String id = JsonValidationUtils.getString(addedByJson, "id", "SpotifyUserDTO");

        // Parse the track information
        JSONObject trackJson = (JSONObject) itemJson.get("track");
        SpotifyTrackDTO trackDTO = parseSpotifyTrack(trackJson);

        SpotifyPlaylistItemDTO itemDTO = new SpotifyPlaylistItemDTO(id, trackDTO);

        return itemDTO;
    }

    /**
     * Parses the JSON object corresponding to the track.
     *
     * @param trackJson JSON object of the track.
     * @return SpotifyTrackDTO object.
     */
    private SpotifyTrackDTO parseSpotifyTrack(JSONObject trackJson) {
        // Parse the album
        JSONObject albumJson = (JSONObject) trackJson.get("album");
        SpotifyAlbumDTO albumDTO = parseSpotifyAlbum(albumJson);

        // Parse the list of artists
        JSONArray artistsJsonArray = JsonValidationUtils.getJSONArray(trackJson, "artists", "SpotifyTrackDTO");
        List<SpotifyArtistDTO> artistsList = new ArrayList<>();
        for (Object artistObj : artistsJsonArray) {
            JSONObject artistJson = (JSONObject) artistObj;
            SpotifyArtistDTO artistDTO = parseSpotifyArtist(artistJson);
            artistsList.add(artistDTO);
        }

        // Parse simple attributes
        boolean explicit = JsonValidationUtils.getBoolean(trackJson, "explicit", "SpotifyTrackDTO");
        String id = JsonValidationUtils.getString(trackJson, "id", "SpotifyTrackDTO");
        boolean isPlayable = JsonValidationUtils.getBoolean(trackJson, "is_playable", "SpotifyTrackDTO");
        String name = JsonValidationUtils.getString(trackJson, "name", "SpotifyTrackDTO");
        int popularity = JsonValidationUtils.getInt(trackJson, "popularity", "SpotifyTrackDTO");

        return new SpotifyTrackDTO(albumDTO, artistsList, explicit, id, isPlayable, name, popularity);
    }

    /**
     * Parses the JSON object corresponding to the album.
     *
     * @param albumJson JSON object of the album.
     * @return SpotifyAlbumDTO object.
     */
    private SpotifyAlbumDTO parseSpotifyAlbum(JSONObject albumJson) {
        return new SpotifyAlbumDTO(
            JsonValidationUtils.getString(albumJson, "album_type", "SpotifyAlbumDTO"),
            JsonValidationUtils.getString(albumJson, "href", "SpotifyAlbumDTO"),
            JsonValidationUtils.getString(albumJson, "id", "SpotifyAlbumDTO"),
            JsonValidationUtils.getString(albumJson, "name", "SpotifyAlbumDTO"),
            JsonValidationUtils.getString(albumJson, "release_date", "SpotifyAlbumDTO"),
            JsonValidationUtils.getInt(albumJson, "total_tracks", "SpotifyAlbumDTO")
        );
    }

    /**
     * Parses the JSON object corresponding to the artist.
     *
     * @param artistJson JSON object of the artist.
     * @return SpotifyArtistDTO object.
     */
    private SpotifyArtistDTO parseSpotifyArtist(JSONObject artistJson) {
        // external_urls is handled as a Map<String, String>
        JSONObject externalUrlsJson = (JSONObject) artistJson.get("external_urls");
        Map<String, String> externalUrls = new HashMap<>();
        if (externalUrlsJson != null) {
            for (Object key : externalUrlsJson.keySet()) {
                String k = (String) key;
                String v = (String) externalUrlsJson.get(k);
                externalUrls.put(k, v);
            }
        }

        return new SpotifyArtistDTO(
            externalUrls,
            JsonValidationUtils.getString(artistJson, "href", "SpotifyArtistDTO"),
            JsonValidationUtils.getString(artistJson, "id", "SpotifyArtistDTO"),
            JsonValidationUtils.getString(artistJson, "name", "SpotifyArtistDTO"),
            JsonValidationUtils.getString(artistJson, "type", "SpotifyArtistDTO"),
            JsonValidationUtils.getString(artistJson, "uri", "SpotifyArtistDTO")
        );
    }
}

