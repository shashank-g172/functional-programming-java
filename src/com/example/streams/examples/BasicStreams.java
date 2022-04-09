package com.example.streams.examples;

import java.util.List;

public class BasicStreams {
    public static void main(String[] args) {
        List<Integer> integers = List.of(10,40,1, 2, 12, 34, 556, 12, 45, 12, 1, 2);
        List<String> strings = List.of("Spring", "Springboot", "SpringSeason", "API", "Microservices", "AWS", "GCP");
        printAllNumbers(integers);
        printEvenNumbers(integers);
        printOddNumbers(integers);
        printSquaresOfEvenNumbers(integers);
        printCubesOfAllOddNumbers(integers);
        printAllIndividualCourses(strings);
        printSpringRelatedStrings(strings);
        printAtLeast4Letters(strings);
        printLengthOfEachString(strings);

    }

    private static void printLengthOfEachString(List<String> strings) {
        strings
                .stream()
                .map(s -> s.length())
                .forEach(System.out::println);
    }

    private static void printCubesOfAllOddNumbers(List<Integer> integers) {
        integers
                .stream()
                .filter(x -> x%2 ==1)
                .map(x -> x*x*x)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbers(List<Integer> integers) {
        integers.stream()
                .filter(x -> x%2==0)
                .map(x -> x*x)
                .forEach(System.out::println);
    }

    private static void printAtLeast4Letters(List<String> strings) {
        strings.stream().filter(x -> x.length() >=4).forEach(System.out::println);
    }

    private static void printSpringRelatedStrings(List<String> strings) {
        strings.stream().filter(x -> x.contains("Spring")).forEach(System.out::println);
    }

    private static void printAllIndividualCourses(List<String> strings) {
        strings.stream().forEach(System.out::println);
    }

    private static void printOddNumbers(List<Integer> integers) {
        integers.stream().filter(x -> x%2==1).forEach(System.out::println);
    }

    private static void printAllNumbers(List<Integer> integers) {
        integers.stream().forEach(System.out::println); // Method reference
    }

    private static void printEvenNumbers(List<Integer> integers) {
        integers.stream().filter(x -> x%2==0).forEach(System.out::println);
    }
}
