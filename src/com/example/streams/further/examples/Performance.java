package com.example.streams.further.examples;

import java.util.List;

public class Performance {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Springboot", "SpringSeason", "API", "Microservices", "AWS", "GCP");

        // All intermediate operators return a stream back! They are lazily executed, only executed when there
        // is a terminal operation
        courses.stream()
                .filter(course -> course.length() > 11)
                .map(String::toUpperCase)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
