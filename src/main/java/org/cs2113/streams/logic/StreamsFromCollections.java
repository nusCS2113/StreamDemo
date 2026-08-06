package org.cs2113.streams.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Creates streams from list and map collections and applies simple transformations to them.
 */
public class StreamsFromCollections {

    private static final int PASSING_SCORE = 50;

    /**
     * Creates an ArrayList containing the integers from 1 through 100.
     *
     * @return the numbers from 1 through 100
     */
    public ArrayList<Integer> createNumbers() {
        return IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Filters the prime numbers, squares them, and collects the results into a new ArrayList.
     *
     * @param numbers numbers to process
     * @return squared prime numbers in encounter order
     */
    public ArrayList<Integer> findSquaredPrimes(List<Integer> numbers) {
        return numbers.stream()
                .filter(StreamsFromCollections::isPrime)
                .map(number -> number * number)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Streams Student objects from an ArrayList and describes the students who passed.
     *
     * @return descriptions containing each passing student's name and grade
     */
    public ArrayList<String> findPassingStudentsFromList() {
        return createStudents().stream()
                .filter(student -> student.getScore() >= PASSING_SCORE)
                .map(student -> student.getName() + ": " + gradeFor(student.getScore()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Streams entries from a HashMap and collects passing students and grades into a new HashMap.
     *
     * @return a map from each passing student's name to their grade
     */
    public HashMap<String, String> findPassingStudentsFromMap() {
        HashMap<String, Integer> scoresByStudent = createStudentScores();

        return scoresByStudent.entrySet().stream()
                .filter(entry -> entry.getValue() >= PASSING_SCORE)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> gradeFor(entry.getValue()),
                        (firstGrade, secondGrade) -> firstGrade,
                        HashMap::new));
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }

    private static String gradeFor(int score) {
        if (score >= 80) {
            return "A";
        } else if (score >= 70) {
            return "B";
        } else if (score >= 60) {
            return "C";
        } else if (score >= PASSING_SCORE) {
            return "D";
        }
        return "F";
    }

    private static ArrayList<Student> createStudents() {
        return new ArrayList<>(List.of(
                new Student("Aisha", 86),
                new Student("Ben", 47),
                new Student("Chen", 73),
                new Student("Divya", 65),
                new Student("Ethan", 39)));
    }

    private static HashMap<String, Integer> createStudentScores() {
        return createStudents().stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Student::getScore,
                        (firstScore, secondScore) -> firstScore,
                        HashMap::new));
    }

    /**
     * Stores a student's name and assessment score for the ArrayList demonstration.
     */
    private static class Student {
        private final String name;
        private final int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        String getName() {
            return name;
        }

        int getScore() {
            return score;
        }
    }
}
