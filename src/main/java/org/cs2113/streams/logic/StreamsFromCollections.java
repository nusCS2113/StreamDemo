package org.cs2113.streams.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.cs2113.streams.model.Student;

/**
 * Creates streams from list and map collections and applies simple transformations to them.
 */
public class StreamsFromCollections {

    private static final int PASSING_SCORE = 50;
    private static final int MINIMUM_SCORE = 45;
    private static final int MAXIMUM_SCORE = 88;
    private static final int RETEST_BONUS = 5;
    private static final long RANDOM_SEED = 13L;

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
     * Streams Student objects from an ArrayList and describes the students who passed.
     *
     * @return descriptions containing each passing student's name and grade
     */
    public ArrayList<String> findPassingStudentsFromList(List<Student> students) {
        return students.stream()
                .filter(student -> student.getScore() >= PASSING_SCORE)
                .map(student -> student.getStudentNumber() + ": " + gradeFor(student.getScore()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Streams entries from a HashMap and collects passing students and grades into a new HashMap.
     *
     * @return a map from each passing student's name to their grade
     */
    public HashMap<Integer, String> findPassingStudentsFromMap(List<Student> students) {
        HashMap<Integer, Integer> scoresByStudent = createStudentScores(students);

        return scoresByStudent.entrySet().stream()
                .filter(entry -> entry.getValue() >= PASSING_SCORE)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> gradeFor(entry.getValue()),
                        (firstGrade, secondGrade) -> firstGrade,
                        HashMap::new));
    }

    /**
     * Selects failing students with prime student numbers and adds five marks for their retest.
     * The map operation creates new Student objects, leaving the original list unchanged.
     *
     * @param students students to process
     * @return new Student objects containing the retest scores
     */
    public ArrayList<Student> applyRetestToFailingPrimeNumberedStudents(List<Student> students) {
        return students.stream()
                .filter(student -> isPrime(student.getStudentNumber()))
                .filter(student -> student.getScore() < PASSING_SCORE)
                .map(student -> student.withScore(student.getScore() + RETEST_BONUS))
                .collect(Collectors.toCollection(ArrayList::new));
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

    /**
     * Creates 100 students with numbers 1 through 100 and uniformly distributed random scores.
     * A fixed seed makes the demonstration reproducible across lecture runs.
     *
     * @return the generated students
     */
    public ArrayList<Student> createStudents() {
        Random random = new Random(RANDOM_SEED);
        return createNumbers().stream()
                .map(studentNumber -> new Student(
                        studentNumber,
                        random.nextInt(MINIMUM_SCORE, MAXIMUM_SCORE + 1)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static HashMap<Integer, Integer> createStudentScores(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getStudentNumber,
                        Student::getScore,
                        (firstScore, secondScore) -> firstScore,
                        HashMap::new));
    }

}
