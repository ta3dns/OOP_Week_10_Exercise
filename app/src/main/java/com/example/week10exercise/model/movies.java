package com.example.week10exercise.model;

public class movies {

    // Variables
    private String title;
    private int year;
    private String genre;
    private String poster;

    // Constructors
    public movies(){}

    public movies(String title, int year, String genre, String poster) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.poster = poster;
    }

    // Getters'
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public String getGenre() {
        return genre;
    }
    public String getPoster() {
        return poster;
    }

    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}

