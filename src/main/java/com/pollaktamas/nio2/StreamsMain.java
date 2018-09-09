package com.pollaktamas.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamsMain {

    public static void main(String[] args) {

        Path path = Paths.get(".");
        try {
            Files.walk(path).forEach(System.out::println);
        } catch (IOException e) {
        }
    }
}
