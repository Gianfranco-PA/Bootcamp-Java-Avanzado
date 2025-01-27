package com.example.refactor.model;

public class Album {
    
    private String id;
    private String name;
    private String releaseDate;
    private Integer totalTracks;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String albumName) {
        this.name = albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String albumReleaseDate) {
        this.releaseDate = albumReleaseDate;
    }

    public Integer getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(Integer albumTotalTracks) {
        this.totalTracks = albumTotalTracks;
    }

    public String getType() {
        return type;
    }

    public void setType(String albumType) {
        this.type = albumType;
    }
}
