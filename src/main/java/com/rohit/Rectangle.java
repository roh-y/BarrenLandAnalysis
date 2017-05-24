package com.rohit;

/**
 * Created by rohityarlagadda on 5/21/17.
 */
public class Rectangle {
    int[] lowerLeftNode;
    int[] upperRightNode;

    public Rectangle(int[] lowerLeftNode, int[] upperRighNode) throws Exception {
        this.lowerLeftNode = lowerLeftNode;
        this.upperRightNode = upperRighNode;
    }
}