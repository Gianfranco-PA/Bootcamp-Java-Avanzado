package com.example.refactor.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> songs;

    public PlayList() {
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }
}
