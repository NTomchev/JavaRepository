package com.company;

public class Song {
    //Declaring fields
    private String songName;
    private GenreEnum genreEnum;
    private String singer;
    private int year;
    private String album;
    private int timesAired;

    //Constructor with all the fields
    public Song(String songName, GenreEnum genreEnum, String singer, int year, String album, int timesAired) {
        this.songName = songName;
        this.genreEnum = genreEnum;
        this.singer = singer;
        this.year = year;
        this.album = album;
        this.timesAired = timesAired;
    }
//Getters and Setters with validation
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        if (songName.length() > 0 && songName.length() <= 30){
            this.songName = songName;
        }else {
            throw new IllegalArgumentException("Song name should not be less than 1 characters and no more than 30 characters");
        }
    }

    public GenreEnum getGenreEnum() {
        return genreEnum;
    }

    public void setGenreEnum(GenreEnum genreEnum) {
        this.genreEnum = genreEnum;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        if (singer.length() > 0 && singer.length() <= 15){
            this.singer = singer;
        }else {
            throw new IllegalArgumentException("Singer name should be between 1 and 15 characters");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        if (album.length() > 0 && album.length() <= 20){
            this.album = album;
        }else {
            throw new IllegalArgumentException("Album name should be between 1 and 15 characters");
        }
    }

    public int getTimesAired() {
        return timesAired;
    }

    public void setTimesAired(int timesAired) {
        this.timesAired = timesAired;
    }


    //Override toString as wanted
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s; ", this.getSongName()))
                .append(this.getGenreEnum())
                .append(String.format("%s; ", this.getSinger()))
                .append(String.format("%s; ", this.getAlbum()))
                .append(this.getYear());

        return sb.toString();
    }
}
