package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay02a {
    public static int HALT = 99;
    public static int ADD = 1;
    public static int MULTIPLY = 2;

    public static void main( String[] args) {
        //int output = runProgram(12, 2);
        int arbitraryOutput = 19690720;

        int finalNoun = 0;
        int finalVerb = 0;
        // this could be made more efficient by exiting the loops when we find our answer but the number of cases is 100 * 100
        for( int noun = 0; noun < 100; noun++) {
            for( int verb = 0; verb < 100; verb++) {
                if( runProgram(noun, verb) == arbitraryOutput ) {
                    finalNoun = noun;
                    finalVerb = verb;
                }
            }
        }

        System.out.println("Final Noun: " + finalNoun);
        System.out.println("Final Verb: " + finalVerb);
    }

    public static int runProgram( int noun, int verb) {
        int[] originalRam = readInput();
        int[] ram = originalRam.clone();
        int programCounter = 0;

        ram[1] = noun;
        ram[2] = verb;
        while( ram[programCounter] != HALT ) {
            int opcode = ram[programCounter];
            int registerA = ram[programCounter + 1];
            int registerB = ram[programCounter + 2];
            int registerC = ram[programCounter + 3];

            if(opcode == ADD) {
                System.out.println("Add");
                ram[registerC] = ram[registerA] + ram[registerB];
            }
            else if(opcode == MULTIPLY) {
                System.out.println("Multiply");
                ram[registerC] = ram[registerA] * ram[registerB];
            }
            programCounter += 4;
        }
        System.out.println("HALT");

        return ram[0];
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
