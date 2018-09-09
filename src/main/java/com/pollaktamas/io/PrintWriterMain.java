package com.pollaktamas.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterMain {

    public static void main(String[] args) {
        System.out.println(new File("A/b/c.txt").getPath());
    }

    public void printExample() throws FileNotFoundException {
        PrintWriter out = new PrintWriter("zoo.log");
        out.print(5);               // PrintWriter method
        out.write(String.valueOf(5));       // Writer method
        out.print(2.0);                 // PrintWriter method
        out.write(String.valueOf(2.0));
    }
}