package com.example.streams.further.examples;

import java.util.List;
import java.util.stream.LongStream;

public class Parallel {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Springboot", "SpringSeason", "API", "Microservices", "AWS", "GCP");

        long time1 = System.currentTimeMillis();
        // Take a huge list of numbers and add them
        System.out.println(LongStream.range(0,10000000).sum());
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(LongStream.range(0,10000000).parallel().sum());
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);

        // Adding parallel executes operations separately and then combines the result
    }
}
