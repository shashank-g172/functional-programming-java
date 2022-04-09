package com.example.streams.custom.examples;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MinAndMax {

    public static void main(String[] args) {

        final List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 2000),
                new Course("Spring Boot", "Framework", 95, 1800),
                new Course("API", "Framework", 96, 2200),
                new Course("Microservices", "Framework", 99, 2500),
                new Course("Full Stack", "FullStack", 92, 1400),
                new Course("AWS", "Cloud", 94, 1900),
                new Course("GCP", "Cloud", 93, 2000),
                new Course("Docker", "Cloud", 91, 2100)
        );
        Comparator compareBySizeAndReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

        // Optional result
        System.out.println(courses.stream()
                .max(compareBySizeAndReviews).get());

        System.out.println(courses.stream()
                .min(compareBySizeAndReviews).get());


        final Predicate<Course> greaterThan90Predicate = course -> course.getReviewScore() > 90;
        System.out.println(
                courses.stream()
                        .filter(greaterThan90Predicate)
                        .findFirst());

        System.out.println(
                courses.stream()
                        .filter(greaterThan90Predicate)
                        .findAny());

        //Average, sum, count
        System.out.println(courses.stream()
                .filter(greaterThan90Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        System.out.println(courses.stream()
                .filter(greaterThan90Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average());

        System.out.println(courses.stream()
                .filter(greaterThan90Predicate)
                .mapToInt(Course::getNoOfStudents)
                .count());
    }
}
