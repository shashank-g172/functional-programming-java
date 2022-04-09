package com.example.file.parse.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParsingExample {

    private static int totalCount =0;
    public static void main(String[] args) throws Exception {
        final String location = "";
        Path path = Paths.get(location);
        List<Path> paths = listAllFiles(path);
        paths.forEach(
                p -> searchWord(p.toFile(), "Kevin")
        );
        System.out.printf("Count: %d", totalCount);
    }

    private static TreeMap<String, Integer> searchWord(File file, String word) {
        TreeMap<String,Integer> occurencesMap = new TreeMap<>();
        int localCount = 0;
        Scanner scanFile;
        try {
            scanFile = new Scanner(file);
            while (null != scanFile.findWithinHorizon("(?i)\\b"+word+"\\b", 0)) {
                MatchResult mr = scanFile.match();
                System.out.printf("Word found : %s at index %d to %d.%n", mr.group(),
                        mr.start(), mr.end());
                totalCount++;
                localCount++;
                occurencesMap.put(file.toString(), occurencesMap.getOrDefault(file.toString(),0)+ 1);
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(occurencesMap.toString());
        return occurencesMap;
    }

    public static List<Path> listAllFiles(Path path) throws Exception {
        List<Path> result;
        try (final Stream<Path> walk = Files.walk(path)) {
                result = walk.filter(Files::isRegularFile)
                        .collect(Collectors.toList());
        }
        return result;
    }

    public static List<Path> findByFileExtension(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)   // is a file
                    .filter(p -> p.getFileName().toString().endsWith(fileExtension))
                    .collect(Collectors.toList());
        }
        return result;
    }
}
