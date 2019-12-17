package com.perlartifex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventDay01b {

    public static void main( String[] args ) {
        System.out.println("Starting the calcs");
        System.out.println(getTheData());
    }

    private static int getTheData() {
        int totalFuel = 0;
        int extraFuel = 0;
        try {
            List<String> content = Files.readAllLines(Paths.get("C:\\Users\\jtaylor\\Downloads\\Advent_Input_01a.txt"), StandardCharsets.US_ASCII);
            for( var value : content ) {
                var mass = Integer.parseInt(value);
                //System.out.println(mass);

                var fuel = calcPod(mass);

                //System.out.println(fuel);

                totalFuel += fuel;
            }

            //totalFuel =  3271095;
            //totalFuel = 100756;
            /*
           int remaining = totalFuel;

            while (remaining > 0) {
                int additionFuel = calcFuel(remaining);
                System.out.println(additionFuel + "," + remaining);
                remaining = additionFuel;
                extraFuel += remaining;
            }

             */
        }
        catch( IOException foo ) {
            System.out.println("Caught an IOException" + foo.toString());
        }

        return extraFuel + totalFuel;
    }

    private static int calcPod(int mass) {
        int remaining = mass;
        int extraFuel = mass;

        while (remaining > 0) {
            int additionFuel = calcFuel(remaining);
            System.out.println(additionFuel + "," + remaining);
            remaining = additionFuel;
            extraFuel += remaining;
        }
        return extraFuel;
    }
    private static int calcFuel(int mass) {
        var fuel = ( mass / 3) - 2;
        fuel = fuel >= 0 ? fuel : 0;
        return fuel;
    }
}
