package com.perlartifex;

import com.perlartifex.BlockPoint;

public class BlockLine {
    private BlockPoint a;
    private BlockPoint b;

    public BlockPoint getA() {
        return a;
    }

    public BlockPoint getB() {
        return b;
    }

    public BlockLine(BlockPoint a, BlockPoint b) {
        this.a = a;
        this.b = b;
    }

    public BlockPoint nearestIntersection(BlockLine otherBlockLine) {
        BlockPoint intersection = null;
        if ( this.isHorizontal() && otherBlockLine.isVertical()) {
        }
        else if ( this.isVertical() && otherBlockLine.isHorizontal()) {
        }
        else if ( this.isVertical() && otherBlockLine.isVertical()) {
        }
        else if ( this.isHorizontal() && otherBlockLine.isHorizontal()) {
        }
        return intersection;
    }

    public boolean isHorizontal() {
        return this.a.getX() == this.b.getX();
    }

    public boolean isVertical() {
        return this.a.getY() == this.b.getY();
    }
}
