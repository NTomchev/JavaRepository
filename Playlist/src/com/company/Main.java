package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //Declaring a Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert number for song list size: ");
        //Input from the console for n - size of the songList
        int n = Integer.parseInt(scanner.nextLine());

        //Calling  checkIfNIsInRange() method;
        checkIfNIsInRange(n);

        //List of songs
        List<Song> songsList = new ArrayList<>();

        //Giving some input data from the console to fill up the list
        System.out.println("Insert some songs in your playlist");
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("/");
            Song song = new Song(tokens[0], GenreEnum.valueOf(tokens[1].toUpperCase()), tokens[2], Integer.parseInt(tokens[3]), tokens[4], Integer.parseInt(tokens[5]));
            songsList.add(song);
        }

        System.out.printf("%nAll songs :%n");
        StringBuilder sb = new StringBuilder();
        //Lambda for appending each objects toString on a new line - done with StringBuilder for optimization
        songsList.forEach(song -> sb.append(song.toString()).append(System.lineSeparator()));

        //Displaying the StringBuilder
        System.out.println(sb.toString());
        Predicate<Song> rockSongs = song -> song.getGenreEnum() == GenreEnum.ROCK;
        Predicate<Song> afterTwoThousand = song -> song.getYear() >= 2000;
        System.out.printf("%nAll ROCK songs%n");
        //Filtering with Lambda
        List<Song> sortedList = songsList.stream()
                .filter(rockSongs.and(afterTwoThousand))
                .collect(Collectors.toList());

        //Printing the sortedList
        sortedList.forEach(song -> System.out.println(song.toString()));

        System.out.printf("%nHighest aired song artist %n");
        //gets the highest aired song
        Song highestAiredSong = songsList.stream()
                .max(Comparator.comparing(Song::getTimesAired))
                .orElseThrow(NoSuchElementException::new);

        //Prints the Singer with the highest aired song
        System.out.println(highestAiredSong.getSinger());

        for (Song song : songsList) {
            if (song.getSinger().equals(highestAiredSong.getSinger())){
                System.out.println(song.toString());
            }
        }

    }

    //Method for checking if n is in valid range
    private static void checkIfNIsInRange(int n) {
        if (n < 1 || n > 5000){
            throw new IllegalArgumentException("Not a valid song range for radio!");
        }
    }
}
