package com.example.streams.modifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Modifications {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Springboot", "SpringSeason", "API", "Microservices", "AWS", "GCP");

        List<String> modifiableList = new ArrayList<>(courses);

        modifiableList.replaceAll(str -> str.toUpperCase(Locale.ROOT));
        modifiableList.removeIf(course -> course.length() < 6);
        System.out.println(modifiableList);

    }
}
