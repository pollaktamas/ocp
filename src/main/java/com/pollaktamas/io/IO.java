package com.pollaktamas.io;

import java.io.File;

public class IO {

    public static void main(String[] args) {

        File constructWithRelativePath = new File("myPath/myFile.txt");
        File constructWithParentAndChildString = new File("parent/a", "myPath/myFile.txt");
    }
}
