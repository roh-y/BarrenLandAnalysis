package com.rohit;

/**
 * Created by rohityarlagadda on 5/21/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BarrenLandAnalyzer m = new BarrenLandAnalyzer();
        m.readInput();
        m.markBarrenLand();
        m.printFertileAreas();//{“48 192 351 207”,“48 392 351 407”,“120 52 135 547”,“260 52 275 547”}

    }



}
