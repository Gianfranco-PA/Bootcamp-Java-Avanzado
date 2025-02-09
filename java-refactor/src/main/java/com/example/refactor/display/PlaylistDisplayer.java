package com.example.refactor.display;

import com.example.refactor.domain.PlayList;

public class PlaylistDisplayer {
    private PlaylistDisplayStrategy strategy;

    public PlaylistDisplayer(PlaylistDisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PlaylistDisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void display(PlayList playlist) {
        strategy.display(playlist);
    }
}

