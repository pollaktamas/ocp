package com.pollaktamas.io;

import java.io.*;

public class FileInputStreamMain {

    public static void main(String[] args) {

    }

    public static void copyMain() throws IOException {
        File source = new File("Zoo.class");
        File destination = new File("ZooCopy.class");
        copy(source, destination);
    }

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream("file");
             OutputStream out = new FileOutputStream(destination, true)) {

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }
}
