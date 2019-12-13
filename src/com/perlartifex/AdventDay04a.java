package com.perlartifex;

public class AdventDay04a {
    private static int START = 256310;
    private static int END = 732736;

    public static void main(String[] args) {
        int total = 0;

        for ( int candidate = START; candidate <= END; candidate++) {
            String[] digits = Integer.toString(candidate).split("");
            if (hasConsecutiveDigits(digits) && hasIncreasingDigits(digits)) {
                System.out.println(candidate);
                total++;
            }
        }

        System.out.print("-------------------------");
        System.out.print(total);
    }

    public static boolean hasConsecutiveDigits(String[] candidate) {
        boolean testResult = false;
        String lastDigit = candidate[0];
        for( int i = 1; i < candidate.length; i++) {
            if(candidate[i].equals(lastDigit)) {
                testResult = true;
                break;
            }
            lastDigit = candidate[i];
        }
        return testResult;
    }

    public static boolean hasIncreasingDigits(String[] candidate) {
        boolean testResult = true;

        int leastDigit = Integer.parseInt(candidate[0]);
        for( int i = 1; i < candidate.length; i++) {
            if(Integer.parseInt(candidate[i]) >= leastDigit) {
                leastDigit = Integer.parseInt(candidate[i]);
            }
            else {
                testResult = false;
                break;
            }
        }

        return testResult;
    }
}
