package com.wrongkey;

public class Tuple<L, R> {
    private final L left;
    private final R right;

    public Tuple(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Tuple{" + left +
                ", " + right +
                "}";
    }
}