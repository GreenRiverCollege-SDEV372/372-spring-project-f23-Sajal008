package com.example.formofart.models;

public class Music {
    private String title;
    private String artist;
    private int year;
    private boolean favorite;

    public Music(String title, String artist, int year, boolean favorite) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.favorite = favorite;
    }

    // Access methods (getters and setters)

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", favorite=" + favorite +
                '}';
    }
}
