package com.rohit;

/**
 * Created by rohityarlagadda on 5/21/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BarrenLandAnalyzer m = new BarrenLandAnalyzer();
        m.readInput();
        m.markBarrenLand();
        m.printFertileAreas();

    }



}