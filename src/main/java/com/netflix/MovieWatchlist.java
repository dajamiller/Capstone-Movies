package com.netflix;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MovieWatchlist {
    public static void main(String[] args) {

        ArrayList<Student> allStudents = new ArrayList<>();
        Student s1 = new Student();
        s1.name = "Daja";
        Student s2 = new Student();
        s2.name = "Hoang";

        allStudents.add(s1);
        allStudents.add(s2);
        System.out.println(allStudents.get(0).name);
        System.out.println(allStudents.get(1).name);
        System.out.println(allStudents.size());





        Scanner scanner = new Scanner(System.in);
        // Start with an empty watchlist (no sample data)
        ArrayList<String> watchlist = new ArrayList<>();
        HashMap<String, Double> ratings = new HashMap<>();



        //   transactions.add("Ergonomic keyboard");
        //   transactions.add("Invoice 1001 paid");

        Movie myMovie = new Movie("Joker",9.0);

        ArrayList<Transaction> allMyTransactions = new ArrayList<>();
        Transaction t1 = new Transaction();
        t1.setDescription("Iphone");
        t1.setAmount(2.0);
        allMyTransactions.add(t1);








        ArrayList<Movie> myMovieList = new ArrayList<>();


        myMovieList.add(myMovie); // Joker + 9.0 rating stored





        HashMap<String, Double> generalRating = new HashMap<>();
        generalRating.put("Joker", 9.0);


        HashMap<String, String> codingLanguages = new HashMap<>();
        codingLanguages.put("Java", "Object oriented lanauage");



        boolean running = true;
        System.out.println(" Welcome to your Movie Watchlist!");
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a movie");
            System.out.println("2. Display all the movies");
            System.out.println("3. Give a movie a rating");
            System.out.println("4. Show how many movies");

            System.out.print("Pick here> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear ENTER
            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String movie = scanner.nextLine();
                    watchlist.add(movie);
                    System.out.println(movie + " added to your watchlist!");
                    break;
                case 2:
                    if (watchlist.isEmpty()) {
                        System.out.println("No movies yet —add some first!");
                    } else {


                        //For each
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

