package com.perlartifex;

public class AdventDay04b {
    private static int START = 256310;
    private static int END = 732736;

    public static void main(String[] args) {
        int total = 0;

        for ( int candidate = START; candidate <= END; candidate++) {
            String[] digits = Integer.toString(candidate).split("");
            if ( hasIncreasingDigits(digits) && hasExactlyTwoConsecutiveDigits(digits)) {
                System.out.println(candidate);
                total++;
            }
        }

        System.out.print("-------------------------");
        System.out.print(total);
    }

    public static boolean hasExactlyTwoConsecutiveDigits(String[] candidate) {
        int matches = 0;
        for( int i = 1; i < candidate.length; i++) {
            if ( candidate[i].equals(candidate[i-1])) {
                matches++;
            }
            else {
                if ( matches == 1 ) return true;
                else matches = 0;
            }
        }
        if ( matches == 1 ) return true;
        else return false;
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
