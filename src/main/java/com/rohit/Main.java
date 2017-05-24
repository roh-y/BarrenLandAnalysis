package com.rohit;

/**
 * Created by rohityarlagadda on 5/21/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BarrenLandAnalyzer m = new BarrenLandAnalyzer();
        m.readInput();
        m.markBarrenLand();
        m.printGrid();
        int i=0;
        System.out.print("{");
        for(Integer area:m.calculateFertileLandArea()){

            if(i == m.calculateFertileLandArea().size()-1){
                System.out.print("\""+area+"\"");
            }else{
                System.out.print("\""+area+"\""+",");
            }
            i++;
        }
        System.out.println("}");


    }

}