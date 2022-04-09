package com.example.streams.examples;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InterfaceAndPredicate {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> strings = List.of("Spring", "Spring Boot", "Spring Season", "API", "Microservices", "AWS", "GCP");

        // Lambda syntax
        numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).forEach(System.out::println);

        //Extracting pieces out
        Predicate<Integer> integerPredicate = x -> x % 2 == 0; // Pass one argument, returns a boolean
        Function<Integer, Integer> integerIntegerFunction = x -> x * x; // Produces a result with one argument
        Consumer<Integer> println = System.out::println; //No result
        numbers.stream().filter(integerPredicate).map(integerIntegerFunction).forEach(println);

        // Find sum of all integers
        final BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> newSum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) { // This is called a function descriptor
                return Integer.sum(integer, integer2);
            }
        };
        System.out.println(numbers.stream().reduce(0, sum));
        System.out.println(numbers.stream().reduce(0, newSum));

        // Filter even numbers by passing the behavior as a parameter to the method
        filterAndPrint(numbers, x-> x%2==0);
        // Filter odd numbers
        filterAndPrint(numbers, x-> x%2!=0);

        System.out.println(filterExercise(numbers, x->x*x).toString());
        System.out.println(filterExercise(numbers, x->x*x*x).toString());
        System.out.println(filterExercise(numbers, x->x+2).toString());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static List<Integer> filterExercise(List<Integer> numbers, Function<Integer,Integer> integerIntegerFunction) {
        return numbers.stream()
                .map(integerIntegerFunction)
                .collect(Collectors.toList());
    }
}
