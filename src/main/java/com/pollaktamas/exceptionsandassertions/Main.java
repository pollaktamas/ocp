package com.pollaktamas.exceptionsandassertions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (FileNotFoundException | RuntimeException e) {
            Exception e1 = e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryWithResources(Path path1, Path path2) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {
            out.write(in.readLine());
        }
    }

    public void rethrow() throws FileNotFoundException {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public static class MyAutoCloseable implements AutoCloseable {
        @Override
        public void close() throws FileNotFoundException {
        }
    }

    public void parseData() throws SQLException, IOException {
    }

    public void multiCatch() throws SQLException, IOException {
        try {
            parseData();
        } catch (SQLException | IOException e) {
            System.err.println(e);
            throw e;
        }
    }

    public void multiCatch2() throws IOException, SQLException {
        try {
            parseData();
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
    }

    public void tryWithMyAutoCloseable() throws FileNotFoundException {
        try (MyAutoCloseable myAutoCloseable = new MyAutoCloseable()) {

        }
    }
}
