package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay05a {

    public static void main( String[] args) {
        int[] originalRam = readInput();
    }

    public static int[] readInput() {

        String pixelData = null;
        try {
            List<String> content = Files.readAllLines(Paths.get("C:\\Users\\elderling\\Downloads\\Advent_Input_02a.txt"), StandardCharsets.US_ASCII);
            pixelData = content.get(0);
        }
        catch( IOException theException ) {
            System.out.println("Caught an IOException" + theException.toString());
        }

        String[] stringElements = pixelData.split(",");

        int[] input = new int[stringElements.length];
        for(int i = 0; i <  stringElements.length; i++) {
            input[i] = Integer.parseInt(stringElements[i]);
            System.out.println(input[i]);
        }

        return input;
    }
}
