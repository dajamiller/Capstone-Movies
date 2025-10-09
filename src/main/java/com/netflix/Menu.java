package com.netflix;

import java.util.Scanner;

public class Menu {

    public static void ShowMenu() {

        Scanner scanner = new Scanner(System.in);

        //boolean running = true;
        boolean running = true;
       // System.out.println(" Welcome to your Movie Watchlist!");

        //while (true) {
        while (true) {
            System.out.println("\n🎬 Welcome to your Movie Watchlist!");
            System.out.println("Choose an option:");
            System.out.println("1. Add a movie");
            System.out.println("2. Display all movies");
            System.out.println("3. Rate a movie");
            System.out.println("4. Show how many movies");
            System.out.println("5. Exit");
            System.out.print("Pick here: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("You chose to add a movie!");
                case 2 -> System.out.println("Displaying your movies...");
                case 3 -> System.out.println("Let's rate a movie!");
                case 4 -> System.out.println("You have X movies.");
                case 5 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}

            //Scanner scanner.nextLine(); // clear ENTER
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter movie title: ");
//                    String movie = scanner.nextLine();
//                    watchlist.add(movie);
//                    System.out.println(movie + " added to your watchlist!");
//                    break;
//                case 2:
//                    if (watchlist.isEmpty()) {
//                        System.out.println("No movies yet —add some first!");
//                    } else {
//
//
//                        //For each
//                        for (String movieTitle : watchlist) {
//                            String rating;
//
//                            if (ratings.containsKey(movieTitle)) {
//                                rating = "⭐" + ratings.get(movieTitle);
//                            } else {
//                                rating = "Not rated yet";
//                            }
//
//                            System.out.println("-" + movieTitle + " (" + rating + ")");
//                        }
//                        System.out.println("Total movies: " + watchlist.size());
//                    }
//                    break;
//                case 3:
//                    System.out.print("Enter movie to rate: ");
//                    String rateMovie = scanner.nextLine();
//                    if (watchlist.contains(rateMovie)) {
//                        System.out.print("Enter rating (0-10): ");
//                        double rate = scanner.nextDouble();
//                        scanner.nextLine();
//                        ratings.put(rateMovie, rate);
//                        System.out.println(rateMovie + " rated " + rate + "⭐!");
//                    } else {
//                        System.out.println("Movie not found in your watchlist.");
//                    }
//                    break;
//                case 4:
//                    running = false;
//                    System.out.println(" Goodbye!");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }



