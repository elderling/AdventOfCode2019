package com.perlartifex;

public class BlockPoint {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    BlockPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int ManhattanDistance( BlockPoint a, BlockPoint b ) {
        int distance;
        distance = Math.abs( a.getX() - b.getX() ) + Math.abs( a.getY() - b.getY() );
        return distance;
    }
}
