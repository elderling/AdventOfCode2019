package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay01a {

    public static void main( String[] args ) {
        System.out.println("Starting the calcs");
        System.out.println(getTheData());
    }

    private static int getTheData() {
        int totalFuel = 0;
        try {
            List<String> content = Files.readAllLines(Paths.get("C:\\Users\\jtaylor\\Downloads\\Advent_Input_01a.txt"), StandardCharsets.US_ASCII);
            for( var value : content ) {
                var mass = Float.parseFloat(value);
                //System.out.println(mass);

                var fuel = (int) (mass / 3) - 2;

                //System.out.println(fuel);

                totalFuel += fuel;
            }
        }
        catch( IOException foo ) {
            System.out.println("Caught an IOException" + foo.toString());
        }
        return totalFuel;
    }
}
