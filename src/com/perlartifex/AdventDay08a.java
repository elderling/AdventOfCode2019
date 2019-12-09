package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventDay08a {
    static int FRAME_HORIZONTAL = 25;
    static int FRAME_VERTICAL = 6;
    static int FRAME_PIXELS = FRAME_HORIZONTAL * FRAME_VERTICAL;

    public static void main( String[] args ) {
        System.out.println("Starting the calcs");
        String rawData = getTheData();
        List<String> charStrings = Arrays.asList(rawData.split(""));
        List<Integer> theData = new ArrayList<Integer>();
        for( String datum : charStrings) {
            theData.add(Integer.parseInt(datum));
        }

        int minZeros = Integer.MAX_VALUE;
        int minOnes = Integer.MAX_VALUE;
        int minTwos = Integer.MAX_VALUE;
        while ( theData.size() > 0) {

            int zeros = 0;
            int ones = 0;
            int twos = 0;
            for (int i = 0; i < FRAME_PIXELS; i++) {
                int data = theData.remove(0);
                //System.out.println(blah);
                if ( data == 1 ) ones++;
                if ( data == 2 ) twos++;
                if ( data == 0 ) zeros++;
            }

            System.out.println(zeros + " " + ones + " " + twos);

            if ( zeros < minZeros ) {
                minZeros = zeros;
                minOnes = ones;
                minTwos = twos;
            }
        }
        System.out.println("------------------------------");
        System.out.println(minZeros + " " + minOnes + " " + minTwos);
    }

    private static String getTheData() {
        String pixelData = null;
        try {
            List<String> content = Files.readAllLines(Paths.get("C:\\Users\\jtaylor\\Downloads\\Advent_Input_08a.txt"), StandardCharsets.US_ASCII);
            pixelData = content.get(0);
        }
        catch( IOException foo ) {
            System.out.println("Caught an IOException" + foo.toString());
        }
        return pixelData;
    }

    class FrameData {
        private int totalOnes = 0;
        private int totalTwos = 0;

        public int getTotalOnes() {
            return totalOnes;
        }

        public void setTotalOnes(int totalOnes) {
            this.totalOnes = totalOnes;
        }

        public void incrementTotalOnes(int totalOnes) {
            this.totalOnes++;
        }

        public int getTotalTwos() {
            return totalTwos;
        }

        public void setTotalTwos(int totalTwos) {
            this.totalTwos = totalTwos;
        }

        public void incrementTotalTwos(int totalOnes) {
            this.totalTwos++;
        }
    }
}
