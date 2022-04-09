package com.example.streams.modifications;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileExample {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("file.txt")).forEach(System.out::println);

        // Find unique words
        Files.lines(Paths.get("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        Files.list(
                Paths.get("."))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    }

}
