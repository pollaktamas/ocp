package com.pollaktamas.nio2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

public class FilesMain {

    public static void main(String[] args) {
        Files.exists(Paths.get("/ostrich/feathers.png"));

        try {
            System.out.println(Files.isSameFile(Paths.get("/user/home/cobra"), Paths.get("/user/home/snake")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.createDirectory(Paths.get("/bison/field"));
            Files.createDirectories(Paths.get("/bison/field/pasture/green"));
        } catch (IOException e) {
        }

        copy();

        try (InputStream is = new FileInputStream("source-data.txt");
             OutputStream out = new FileOutputStream("output-data.txt")) {
            Files.copy(is, Paths.get("c:\\mammals\\wolf.txt"));
            Files.copy(Paths.get("c:\\fish\\clown.xsl"), out);
        } catch (IOException e) {
        }
    }

    private static void copy() {
        try {
            Files.copy(Paths.get("/panda"), Paths.get("/panda-save"));
            Files.copy(Paths.get("/panda/bamboo.txt"), Paths.get("/panda-save/bamboo.txt"));
        } catch (IOException e) {
        }
    }

    public void move() {
        try {
            Files.move(Paths.get("c:\\zoo"), Paths.get("c:\\zoo-new"));
            Files.move(Paths.get("c:\\user\\addresses.txt"),
                    Paths.get("c:\\zoo-new\\addresses.txt"));
        } catch (IOException e) {
        }
    }

    public void delete() {
        try {
            Files.delete(Paths.get("/vulture/feathers.txt"));
            Files.deleteIfExists(Paths.get("/pigeon"));
        } catch (IOException e) {
        }
    }

    public void bufferedReader() {
        Path path = Paths.get("/animals/gopher.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"))) {
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
        }
    }

    public void bufferedWriter() {
        Path path = Paths.get("/animals/gorilla.txt");
        List<String> data = new ArrayList<>();
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-16"))) {
            writer.write("Hello World");
        } catch (IOException e) {
        }
    }

    public void readAllLines() {
        Path path = Paths.get("/fish/sharks.log");
        try {
            final List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
        }
    }

    public void lastModifiedTime() {
        try {
            final Path path = Paths.get("/rabbit/food.jpg");
            System.out.println(Files.getLastModifiedTime(path).toMillis());
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
            System.out.println(Files.getLastModifiedTime(path).toMillis());
        } catch (IOException e) {
        }
    }
}
