package com.rohit;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
/**
 * Created by rohityarlagadda on 5/23/17.
 */
public class BarrenLandAnalyzerTest {
    @Test
    public void testBarrenAnalyzerWithCorrectInput() throws Exception {

        BarrenLandAnalyzer b = new BarrenLandAnalyzer();
        String[] args = new String[]{"48 192 351 207","48 392 351 407","120 52 135 547","260 52 275 547"};
        b.parseInput(args);
        b.resetMatrix();
        b.markBarrenLand();
        List<Integer> areas = b.calculateFertileLandArea();

        Assert.assertEquals(new Integer(22816), areas.get(0));
        Assert.assertEquals(new Integer(192608), areas.get(1));

    }

    @Test
    public void testBarrenAnalyzerWithCorrectInput2() throws Exception {

        BarrenLandAnalyzer b = new BarrenLandAnalyzer();
        String[] args = new String[]{"0 292 399 307"};
        b.parseInput(args);
        b.resetMatrix();
        b.markBarrenLand();
        List<Integer> areas = b.calculateFertileLandArea();


        Assert.assertEquals(new Integer(116800), areas.get(0));
        Assert.assertEquals(new Integer(116800), areas.get(1));

    }

//    @Test
//    public void testBarrenAnalyzerWithCorrectInput3() throws Exception {
//
//        BarrenLandAnalyzer b = new BarrenLandAnalyzer();
//        String[] args = new String[]{"0 0 3 1"};
//        b.parseInput(args);
//        b.resetMatrix();
//        b.markBarrenLand();
//        List<Integer> areas = b.calculateFertileLandArea();
//
//
//        Assert.assertEquals(new Integer(22), areas.get(0));
//
//    }
}