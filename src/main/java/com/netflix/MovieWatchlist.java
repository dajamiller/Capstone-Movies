package com.netflix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


//ArrayList<Transaction> allMyTransactions = new ArrayList<>();
//Transaction t1 = new Transaction();
//t1.setDescription("Iphone");
//t1.setAmount(2.0);
//allMyTransactions.add(t1);

public class MovieWatchlist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Start with an empty watchlist (no sample data)
        ArrayList<String> watchlist = new ArrayList<>();
        HashMap<String, Double> ratings = new HashMap<>();

        ArrayList<Movie> myMovieList = new ArrayList<>();
        Movie myMovie = new Movie("Joker",9.0);
        myMovieList.add(myMovie);

        //HashMap<String, Double> basketballRating = new HashMap<>();
        //basketballRating.put("Lebron James", 25.0);

        boolean running = true;
        System.out.println(" Welcome to your Movie Watchlist!");
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("(1) Add a movie");
            System.out.println("(2) Display all movies");
            System.out.println("(3) Rate a movie");
            System.out.println("(4) Exit");
            System.out.print("> ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // clear ENTER
            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String movie = scanner.nextLine();
                    watchlist.add(movie);
                    try {

                        FileWriter myWriter = new FileWriter("Watchlist.txt");
                        myWriter.write(movie);
                        myWriter.close();  // must close manually
                        System.out.println("Movie added to Watchlist!");
                    } catch (IOException e) {
                        System.out.println("Try Again...");
                        e.printStackTrace();
                    }
                   // System.out.println(movie + " added to your watchlist!");
                    break;
                case 2:
                    System.out.println("\nYour Watchlist: ");
                    if (watchlist.isEmpty()) {
                        System.out.println("No movies yet — add some first!");
                    } else {
                        for (String movieTitle : watchlist) {
                            String rating;

                            if (ratings.containsKey(movieTitle)) {
                                rating = "⭐" + ratings.get(movieTitle);
                            } else {
                                rating = "Not rated yet";
                            }
                            System.out.println("-" + movieTitle + " (" + rating + ")");

                        }
                        System.out.println("Total movies: " + watchlist.size());
                    }
                    break;
                case 3:
                    System.out.print("Enter movie to rate: ");
                    String rateMovie = scanner.nextLine();
                    if (watchlist.contains(rateMovie)) {
                        System.out.print("Enter rating (0-10): ");
                        double rate = scanner.nextDouble();
                        scanner.nextLine();
                        ratings.put(rateMovie, rate);
                        System.out.println(rateMovie + " rated " + rate + "⭐!");
                    } else {
                        System.out.println("Movie not found in your watchlist.");
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println(" Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

