package org.cs2113.streams.model;

/**
 * Represents a student identified by a student number and an assessment score.
 * Instances are immutable so stream transformations do not modify their source objects.
 */
public class Student {
    private final int studentNumber;
    private final int score;

    /**
     * Creates a student with the given number and score.
     *
     * @param studentNumber unique student number
     * @param score assessment score
     */
    public Student(int studentNumber, int score) {
        this.studentNumber = studentNumber;
        this.score = score;
    }

    /**
     * Returns the student's unique number.
     *
     * @return the student number
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * Returns the student's score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Creates a copy of this student with a different score.
     *
     * @param newScore score for the copy
     * @return a new Student with the same student number and the new score
     */
    public Student withScore(int newScore) {
        return new Student(studentNumber, newScore);
    }

    @Override
    public String toString() {
        return "Student{" + "studentNumber=" + studentNumber + ", score=" + score + '}';
    }
}
