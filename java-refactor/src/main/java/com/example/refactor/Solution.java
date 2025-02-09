package com.example.refactor;
import com.example.refactor.display.DefaultPlaylistDisplayStrategy;
import com.example.refactor.facade.PlaylistFacade;

public class Solution {
    public static void main(String... args) {
        PlaylistFacade facade = new PlaylistFacade(new DefaultPlaylistDisplayStrategy());
        facade.showPlaylist();
    }
}
