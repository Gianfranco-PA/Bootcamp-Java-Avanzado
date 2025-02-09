package com.example.refactor.service.playlist;

import com.example.refactor.domain.PlayList;

public abstract class PlaylistServiceTemplate<R,T> implements IPlaylistService {

    @Override
    public final PlayList getPlayList() {
        R rawData = retrieveRawData();
        T dto = parseRawData(rawData);
        return mapDtoToDomain(dto);
    }

    protected abstract R retrieveRawData();

    protected abstract T parseRawData(R rawData);

    protected abstract PlayList mapDtoToDomain(T dto);
}
