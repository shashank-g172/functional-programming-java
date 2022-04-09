package com.example.streams.examples;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class SupplierExample {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> strings = List.of("Spring", "Spring Boot", "Spring Season", "API", "Microservices", "AWS", "GCP");

        //Supplier - Opposite of Consumer. No input, return some output (Factory pattern)
        Supplier<Integer> randomIntegerSupplierExample = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupplierExample.get());

        //UnaryOperator - Takes one input, returns the result of same type
        UnaryOperator<Integer> integerUnaryOperator = (x) -> x*3;
        System.out.println(integerUnaryOperator.apply(10));

        //BiPredicate - 2 input types, output is boolean
        BiPredicate<Integer, String> biPredicate = (x, y) -> true;
        BiPredicate<Integer, String> usefulBiPredicate = (number, str) -> {
            return number <10 && str.length() >5;
        };
        System.out.println(usefulBiPredicate.test(5, "lifeishard"));

        //BiFunction -  Take 2 inputs, returns one output which is a string in this case (3rd argument)
        BiFunction<Integer, String, String> usefulBiFunction = (number, str) -> {
            return number+" " +str;
        };

        System.out.println(usefulBiFunction.apply(5, "lifeisHard"));

        //BiConsumer - No return value
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept("LifeISHard", "ButOnlyIfYouDontTry");

        //For primary types, use IntBinaryOperator, IntConsumer, IntToLongFunction etc. They are primitive Lambda function
        IntBinaryOperator intBinaryOperator = (x,y) -> x+y;
        System.out.println(intBinaryOperator.applyAsInt(4, 5));
    }
}
