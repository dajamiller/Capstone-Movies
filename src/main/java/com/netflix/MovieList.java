package com.netflix;

import java.util.ArrayList;

public class MovieList {
    public int Si;
    private String title;
    private double rating;
    private ArrayList<Movie> list = new ArrayList<>();


    public MovieList(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public MovieList() {

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public double getRating() {

        return rating;
    }

    public void setRating(double rating) {

        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }

    public void addMovie(String title, double rating) {
        list.add(new Movie(title, rating));

    }

    public void displayAll() {
    }

    public void updateRating(String title, double rating) {
    }

    public void showCount() {
    }

    public void saveToCsv(String s) {
    }

    public void loadFromCsv(String s) {
       // list.loadFromCsv("movies.csv");

    }
}



