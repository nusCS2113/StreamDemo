package org.cs2113.streams.ui;

import java.util.ArrayList;

import org.cs2113.streams.logic.StreamsFromCollections;
import org.cs2113.streams.model.Student;

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
        ArrayList<Student> students = streams.createStudents();

        System.out.println("Passing students from ArrayList: "
                + streams.findPassingStudentsFromList(students));
        System.out.println("Passing students from HashMap: "
                + streams.findPassingStudentsFromMap(students));
        System.out.println("Retest results for failing students with prime student numbers: "
                + streams.applyRetestToFailingPrimeNumberedStudents(students));
    }
}
