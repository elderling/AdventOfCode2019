package com.perlartifex;

public class BlockPoint {
    int x, y;

    BlockPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int ManhattanDistance( BlockPoint a, BlockPoint b ) {
        int distance = Math.abs( a.x - b.x ) + Math.abs( a.y - b.y );
        return distance;
    }
}
