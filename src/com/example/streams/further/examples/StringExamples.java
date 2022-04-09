package com.example.streams.further.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringExamples {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Springboot", "SpringSeason", "API", "Microservices", "AWS", "GCP");

        System.out.println(courses.
                stream().
                collect(Collectors.joining(" ")));

        System.out.println(courses
                .stream()
                .map(course -> course.split(("")))
                        .flatMap(Arrays::stream) // Each element of the stream is replaced with content of mapped stream
                .collect(Collectors.toList()));

        System.out.println(courses
                .stream()
                .map(course -> course.split(("")))
                .flatMap(Arrays::stream) // Each element of the stream is replaced with content of mapped stream
                .distinct()
                .collect(Collectors.toList()));

        // identify Tuples of same length
        List<String> courses2 = List.of("Spring", "Springboot", "SpringSeason", "API", "Microservices", "AWS", "GCP");
        System.out.println(courses.
                stream()
                .flatMap(course -> courses2.stream()
                        .filter(course2 -> course2.length() == course.length())
                        .map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));
    }
}
