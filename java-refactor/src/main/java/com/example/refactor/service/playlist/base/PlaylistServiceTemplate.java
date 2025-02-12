package com.example.refactor.service.playlist.base;

import com.example.refactor.domain.Playlist;

public abstract class PlaylistServiceTemplate<R,T> implements IPlaylistService {

    @Override
    public final Playlist getPlayList() {
        R rawData = retrieveRawData();
        T dto = parseRawData(rawData);
        return mapDtoToDomain(dto);
    }

    protected abstract R retrieveRawData();

    protected abstract T parseRawData(R rawData);

    protected abstract Playlist mapDtoToDomain(T dto);
}
