package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AdventDay03a {
    public static void main(String[] args) {
        List<String> content = readThemLines();
        String pathOne = content.get(0);
        System.out.println(pathOne);
        String pathTwo = content.get(1);
        System.out.println(pathTwo);

        List<String> instructionsOne = getInstructions(pathOne);
        for ( String foo : instructionsOne) {
            System.out.println(foo);
        }
        List<String> instructionsTwo = getInstructions(pathTwo);
        for ( String foo : instructionsTwo) {
            System.out.println(foo);
        }
    }

    private static List<String> readThemLines() {
        List<String> content = null;
        try {
            content = Files.readAllLines(Paths.get("C:\\Users\\jtaylor\\Downloads\\Advent_Input_03a.txt"), StandardCharsets.US_ASCII);
        } catch (IOException foo) {
            System.out.println("Caught an IOException" + foo.toString());
        }
        return content;
    }

    private static List<String> getInstructions (String theInstructions) {
        List<String> instructions;
        instructions = Arrays.asList(theInstructions.split(","));
        return instructions;
    }
}
