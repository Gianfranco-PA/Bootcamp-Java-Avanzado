package com.example.refactor.utils.files;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.refactor.exception.JsonParsingException;
import com.example.refactor.model.Album;
import com.example.refactor.model.Artist;
import com.example.refactor.model.PlayList;
import com.example.refactor.model.Song;

public class JsonFileParser implements IFileParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonFileParser.class);

    @Override
    public PlayList extracPlayList(File inputSource) {
        JSONParser parser = new JSONParser();
        try (FileReader fileReader = new FileReader(inputSource)) {
            JSONObject rootObject = (JSONObject) parser.parse(fileReader);
            JSONArray items = validateRoot(rootObject);

            PlayList playList = new PlayList();
            for (Object item : items) {
                JSONObject songItem = (JSONObject) item;
                Song song = parseSong(songItem);
                playList.addSong(song);
            }
            return playList;
        } catch (IOException | ParseException e) {
            LOGGER.error("Error reading the JSON file", e);
            return null;
        }
    }

    // Validate the root object and return the items array
    private JSONArray validateRoot(JSONObject rootObject) {
        if (rootObject == null) {
            throw new JsonParsingException("Invalid JSON file: null object");
        }
        if (rootObject.isEmpty()) {
            throw new JsonParsingException("JSON file is empty");
        }

        return JsonValidationUtils.getJSONArray(rootObject, "items", "root");
    }

    // Parse a song item and return a Song object
    private Song parseSong(JSONObject songItem) {
        JsonValidationUtils.validateKeyExists(songItem, "track", "item");
        JSONObject trackJSON = (JSONObject) songItem.get("track");

        Song song = new Song();
        song.setId(JsonValidationUtils.getString(trackJSON, "id", "track"));
        song.setExplicit(JsonValidationUtils.getBoolean(trackJSON, "explicit", "track"));
        song.setPlayable(JsonValidationUtils.getBoolean(trackJSON, "is_playable", "track"));
        song.setName(JsonValidationUtils.getString(trackJSON, "name", "track"));
        song.setPopularity(JsonValidationUtils.getInt(trackJSON, "popularity", "track"));

        // Parsing album
        JsonValidationUtils.validateKeyExists(trackJSON, "album", "track");
        JSONObject albumJSON = (JSONObject) trackJSON.get("album");
        Album album = parseAlbum(albumJSON);
        song.setAlbum(album);

        // Parsing artists
        JSONArray artistsArray = JsonValidationUtils.getJSONArray(trackJSON, "artists", "track");
        for (Object artistObj : artistsArray) {
            JSONObject artistJSON = (JSONObject) artistObj;
            Artist artist = parseArtist(artistJSON);
            song.addArtist(artist);
        }
        return song;
    }

    // Parse an album JSON object and return an Album object
    private Album parseAlbum(JSONObject albumJSON) {
        Album album = new Album();
        album.setId(JsonValidationUtils.getString(albumJSON, "id", "album"));
        album.setName(JsonValidationUtils.getString(albumJSON, "name", "album"));
        album.setType(JsonValidationUtils.getString(albumJSON, "album_type", "album"));
        album.setReleaseDate(JsonValidationUtils.getString(albumJSON, "release_date", "album"));
        album.setTotalTracks(JsonValidationUtils.getInt(albumJSON, "total_tracks", "album"));
        return album;
    }

    // Parse an artist JSON object and return an Artist object
    private Artist parseArtist(JSONObject artistJSON) {
        Artist artist = new Artist();
        artist.setId(JsonValidationUtils.getString(artistJSON, "id", "artist"));
        artist.setName(JsonValidationUtils.getString(artistJSON, "name", "artist"));
        return artist;
    }
}
