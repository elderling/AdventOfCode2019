package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventDay08a {

    public static void main( String[] args ) {
        System.out.println("Starting the calcs");
        String rawData = getTheData();
        List<String> charStrings = Arrays.asList(rawData.split(""));
        List<Integer> theData = new ArrayList<Integer>();
        for( String datum : charStrings) {
            theData.add(Integer.parseInt(datum));
        }
        System.out.println(theData);
    }

    private static String getTheData() {
        String pixelData = null;
        try {
            List<String> content = Files.readAllLines(Paths.get("C:\\Users\\elderling\\Downloads\\Advent_Input_08a.txt"), StandardCharsets.US_ASCII);
            pixelData = content.get(0);
        }
        catch( IOException foo ) {
            System.out.println("Caught an IOException" + foo.toString());
        }
        return pixelData;
    }

    class LayerStuff {

    }
}
