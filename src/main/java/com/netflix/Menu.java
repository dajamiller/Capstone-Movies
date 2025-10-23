package com.netflix;
import java.util.Scanner;

public class Menu {

    public static void ShowMenu() {
        Scanner scanner = new Scanner(System.in);
        MovieList list = new MovieList();
        list.loadFromCsv("movies.csv"); // ✅ same file for load + save
        boolean running = true;

        while (running) {
            System.out.println("\n🎬 Welcome to your Movie Watchlist!");
            System.out.println("1. Add a movie");
            System.out.println("2. Display all movies");
            System.out.println("3. Rate a movie");
            System.out.println("4. Show how many movies");
            System.out.println("5. Exit");
            System.out.print("Pick here: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addMovie(list, scanner);
                case 2 -> list.displayAll();
                case 3 -> rateMovie(list, scanner);
                case 4 -> list.showCount();
                case 5 -> {
                    list.saveToCsv("movies.csv");
                    System.out.println("💾 Changes saved. Goodbye!");
                    running = false;
                }
                default -> System.out.println("⚠️ Invalid choice, try again!");
            }
        }
    }

    private static void addMovie(MovieList list, Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter rating (0–5): ");
        double rating = scanner.nextDouble();
        list.addMovie(title, rating);
        list.saveToCsv("movies.csv");
    }

    private static void rateMovie(MovieList list, Scanner scanner) {
        System.out.print("Enter movie title to rate: ");
        String title = scanner.nextLine();
        System.out.print("Enter new rating (0–5): ");
        double rating = scanner.nextDouble();
        list.updateRating(title, rating);
        list.saveToCsv("movies.csv");

    }
}
