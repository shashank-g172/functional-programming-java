package com.example.streams.custom.examples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Grouping {

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

        // Group by a specific category
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        // {Cloud=3, FullStack=1, Framework=4}
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        //Get the highest reviews of each of the categories
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        //Get the highest reviews of each of the categories, but just the names of the courses
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList()))));
    }
}
