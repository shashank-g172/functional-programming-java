package com.example.streams.examples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAndSort {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> strings = List.of("Spring", "Spring Boot", "Spring Season", "API", "Microservices", "AWS", "GCP");
        int sum = addList(numbers);
        int sumUsingLambda = addListUsingLambda(numbers);
        int sumUsingInBuiltFunction = addListUsingInBuiltfunction(numbers);
        System.out.println(sum);
        System.out.println(sumUsingLambda);
        System.out.println(sumUsingInBuiltFunction);

        System.out.println(findMaxOnlyPositiveNumbers(numbers));
        System.out.println(findMin(List.of(-12,-9,13,-4,6,2,-4,12,15)));

        System.out.println(findAndReturnSumOfSquares(numbers));
        System.out.println(findAndReturnSumOfCubes(numbers));
        System.out.println(findSumOfOddNumbersInList(numbers));

        System.out.println(findDistinctNumbers(numbers).toString());
        System.out.println(sortArray(numbers));
        System.out.println(sortStrings(strings));
        System.out.println(sortStringsInReverse(strings));
        System.out.println(sortByLengthOfStrings(strings));

        //New lists are returned from the following methods
        System.out.println(createEvenNumbersOnly(numbers));
        System.out.println(createListWithLengthsofAllTitles(strings));
    }

    private static List<Integer> createListWithLengthsofAllTitles(List<String> strings) {
        return strings.stream().map(s ->s.length()).collect(Collectors.toList());
    }

    private static List<Integer> createEvenNumbersOnly(List<Integer> numbers) {
        return numbers.stream().filter(x -> x%2==0).collect(Collectors.toList());
    }

    private static List<String> sortByLengthOfStrings(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(s ->s.length())).toList();
    }

    private static List<String> sortStringsInReverse(List<String> strings) {
        return strings.stream().sorted(Comparator.reverseOrder()).toList();
    }

    private static List<String> sortStrings(List<String> strings) {
        return strings
                .stream()
                .sorted()
                .toList();
    }

    private static List<Integer> sortArray(List<Integer> numbers) {
        return
                numbers.stream().distinct().sorted().toList();
    }

    private static List<Integer> findDistinctNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .toList();
    }



    private static int findSumOfOddNumbersInList(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(x -> x%2==1) // restrict to only odd numbers
                .reduce(0, Integer::sum);
    }

    private static int findAndReturnSumOfCubes(List<Integer> numbers) {
        return numbers
                .stream()
                .map(x -> x*x*x)
                .reduce(0, Integer::sum);
    }

    private static int findAndReturnSumOfSquares(List<Integer> numbers) {
        return
                numbers
                        .stream()
                        .map(x -> x*x) // Square each element first
                        .reduce(0, Integer::sum); // Then add it to the aggregator
    }

    private static int findMaxOnlyPositiveNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, (x,y) -> x> y?x:y);
    }

    private static int findMin(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(Integer.MAX_VALUE, (x,y) -> x<y?x:y);
    }

    private static int addListUsingInBuiltfunction(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, Integer::sum);
    }

    private static int addListUsingLambda(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, (x,y) -> x+y);
    }

    private static int addList(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0,StreamAndSort::addNumbers);
    }

    private static Integer addNumbers(Integer aggregate, Integer nextNumber) {
        return aggregate+nextNumber;
    }
}
