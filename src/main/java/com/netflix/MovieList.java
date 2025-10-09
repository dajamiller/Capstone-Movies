package com.netflix;

import com.netflix.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieList {

    // 🔹 Store all movies in a dynamic list
    private List<Movie> movies;

    // 🔹 Constructor
    public MovieList() {
        movies = new ArrayList<>();
    }

    // 🔹 Add a movie
    public void addMovie(String title, double rating) {
        movies.add(new Movie(title, rating));
        System.out.println("✅ Added movie: " + title + " (⭐ " + rating + ")");
    }

    // 🔹 Display all movies
    public void displayAll() {
        if (movies.isEmpty()) {
            System.out.println("📭 Your movie list is empty.");
            return;
        }

        System.out.println("\n🎞 Your Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, movies.get(i));
        }
    }
    public void displayAllTitles() {
        for (Movie m : movies)
            System.out.println(m.getTitle());
    }

    public void displayAllTitlesAndRating() {
        for (Movie m : movies)
            System.out.println(m.getTitle() + " " + m.getRating());
    }

    // 🔹 Find a movie by title
    public Movie findMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    // 🔹 Update a movie rating
    public void updateRating(String title, double newRating) {
        Movie movie = findMovie(title);
        if (movie != null) {
            movie.setRating(newRating);
            System.out.println("⭐ Updated " + title + " to " + newRating + " stars.");
        } else {
            System.out.println("❌ Movie not found: " + title);
        }
    }

    // 🔹 Show total count
    public void showCount() {
        System.out.println("📊 Total movies: " + movies.size());
    }

    // 🔹 Optional: get all movies (for use in other classes)
    public List<Movie> getMovies() {
        return movies;
    }

    public void saveToCsv(String fileName) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(fileName))) {
            for (Movie m : movies)
                w.write(m.getTitle() + "," + m.getRating() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void loadFromCsv(String fileName) {
        movies.clear();
        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] p = line.split(",", 2);
                if (p.length == 2)
                    movies.add(new Movie(p[0], Double.parseDouble(p[1])));
            }
        } catch (IOException e) { /* ignore if file missing */ }
    }
}