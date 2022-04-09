package com.example.streams.custom.examples;

import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private  int noOfStudents;
}

public class CustomClass {

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

        //AllMatch, NoneMatch, anyMatch
        final Predicate<Course> greaterThan90Predicate = course -> course.getReviewScore() > 90;
        System.out.println(courses.stream()
                .allMatch(greaterThan90Predicate));

        final Predicate<Course> lessThanCoursePredicate = course -> course.getReviewScore() < 90;
        System.out.println(courses.stream()
                .noneMatch(lessThanCoursePredicate));

        // at least one matches this predicate
        System.out.println(courses.stream()
                .anyMatch(lessThanCoursePredicate));

        //Sort
        Comparator increasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator decreasing = Comparator.comparing(Course::getNoOfStudents).reversed();

        Comparator compareBySizeAndReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

        System.out.println(courses.stream().sorted(increasing).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(decreasing).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(compareBySizeAndReviews).collect(Collectors.toList()));

        // Skip and Limit
        System.out.println(courses.stream().sorted(compareBySizeAndReviews).limit(5).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(compareBySizeAndReviews).skip(3).collect(Collectors.toList()));

        //TakeWhile and DropWhile
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore() >=95)
                .collect(Collectors.toList()));

        // DropWhile - keep checking until the condition is true
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore() >=95)
                .collect(Collectors.toList()));
    }
}
