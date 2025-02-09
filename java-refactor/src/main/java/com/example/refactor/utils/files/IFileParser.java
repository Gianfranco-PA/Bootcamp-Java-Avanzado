package com.example.refactor.utils.files;

import java.io.File;

import com.example.refactor.domain.PlayList;

public interface IFileParser {
    public PlayList extracPlayList(File inputSource);
}
