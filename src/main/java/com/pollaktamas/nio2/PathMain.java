package com.pollaktamas.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMain {

    public static void main(String[] args) {
        Path path = Paths.get("c:", "alma", "bela");
        System.out.println(path.getNameCount());
        Path pathThird = path.getName(1);

        Path path3 = Paths.get("/", "home", "zoodirector");
        FileSystems.getDefault();
        path.toUri();

        Path absoluteUnixPath = Paths.get("/home/dir/my.txt");
        System.out.println(absoluteUnixPath);
        System.out.println(absoluteUnixPath.isAbsolute());

        Path path1 = Paths.get("C:\\birds\\egret.txt");
        System.out.println("Path1 is Absolute? " + path1.isAbsolute());
        System.out.println("Absolute Path1: " + path1.toAbsolutePath());

        Path path2 = Paths.get("birds/condor.txt");
        System.out.println("Path2 is Absolute? " + path2.isAbsolute());
        Path path4 = path2.toAbsolutePath();
        Path path5 = path4.toAbsolutePath();
        System.out.println("Absolute Path2 " + path4);

        subpath();
        relativize(path3);

        try {
            System.out.println(Paths.get(".").toRealPath());
        } catch (IOException e) {
        }
    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null) {
            System.out.println(" Current parent is: " + currentParent);
        }
    }

    private static void subpath() {
        Path path = Paths.get("/mammal/carnivore/raccoon.image");
        System.out.println("Path is: " + path);
        System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
        System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
        System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));
    }

    private static void relativize(Path path3) {
        Path path1 = Paths.get("/primate/chimpanzee");
        Path path2 = Paths.get("/bananas.txt");
        path1.relativize(path2);
    }
}
