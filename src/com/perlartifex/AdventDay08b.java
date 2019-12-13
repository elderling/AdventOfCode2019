package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventDay08b {
    static int FRAME_HORIZONTAL = 25;
    static int FRAME_VERTICAL = 6;
    static int FRAME_PIXELS = FRAME_HORIZONTAL * FRAME_VERTICAL;
    static String BLACK = "0";
    static String WHITE = "1";
    static String TRANSPARENT = " ";

    public static void main( String[] args ) {
        System.out.println("Starting the calcs");

        int[] dataStream = getTheData();
        int[] workSpace = new int[FRAME_PIXELS];
        for(int i = 0; i < workSpace.length; i++) workSpace[i] = 2;
        int numberOfFrames = dataStream.length/FRAME_PIXELS;

        for(int i = 0; i < numberOfFrames; i++) {
            for( int n = 0; n < FRAME_PIXELS; n++ ) {
               int pixel = dataStream[i * FRAME_PIXELS + n];
                if( workSpace[n] == 2 ) {
                    workSpace[n] = pixel;
                }
            }
        }

        for(int i = 0; i < FRAME_VERTICAL; i++) {
            for( int n = 0; n < FRAME_HORIZONTAL; n++ ) {
                int pixel = workSpace[ i * FRAME_VERTICAL + n];
                if (pixel == 0) {
                    System.out.print("B");
                }
                else if (pixel == 1) {
                    System.out.print("W");
                }
                else {
                    System.out.print("W");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[] getTheData() {
        String pixelData = null;
        try {
            List<String> content = Files.readAllLines(Paths.get("C:\\Users\\jtaylor\\Downloads\\Advent_Input_08a.txt"), StandardCharsets.US_ASCII);
            pixelData = content.get(0);
        }
        catch( IOException foo ) {
            System.out.println("Caught an IOException" + foo.toString());
        }

        String[] themStrings = pixelData.split("");

        int[] intArray = new int[themStrings.length];
        for(int i =0; i < themStrings.length; i++) {
            intArray[i] = Integer.parseInt(themStrings[i]);
        }

        return intArray;
    }
}
