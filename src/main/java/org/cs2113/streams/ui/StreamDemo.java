package org.cs2113.streams.ui;

import java.util.ArrayList;

import org.cs2113.streams.logic.StreamsFromCollections;

/**
 * Entry point for demonstrations of streams created from Java collections.
 */
public class StreamDemo {

    /**
     * Runs the collection stream demonstrations and displays their results.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        StreamsFromCollections streams = new StreamsFromCollections();
        ArrayList<Integer> numbers = streams.createNumbers();

        System.out.println("Squared prime numbers: " + streams.findSquaredPrimes(numbers));
        System.out.println("Passing students from ArrayList: "
                + streams.findPassingStudentsFromList());
        System.out.println("Passing students from HashMap: "
                + streams.findPassingStudentsFromMap());
    }
}
