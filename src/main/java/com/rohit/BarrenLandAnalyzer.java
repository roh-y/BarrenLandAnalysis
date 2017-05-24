package com.rohit;

import java.util.*;

/**
 * Created by rohityarlagadda on 5/21/17.
 */
public class BarrenLandAnalyzer {

    public static final int LENGTH = 400;
    public static final int WIDTH = 600;

    public int[][] fieldMatrix = new int[LENGTH][WIDTH];
    public List<Rectangle> barrenRectangles = new ArrayList<Rectangle>();
    public HashMap<Integer, Integer> fertileAreaMap = new HashMap<Integer, Integer>(); //Used because of its over riding feature.
    public LinkedList<int[]> queue = new LinkedList<int[]>();

    public int[] startNode =new int[]{0,0};

    public boolean getFertileFieldStartNode(){ //Gets the node of the fertile land (Linear Search)
        for(int i=0;i<LENGTH-1;i++){
            for(int j =0;j<WIDTH-1;j++){
                if(fieldMatrix[i][j]==0){// Checking for the fertile node
                    startNode[0]=i;
                    startNode[1]=j;
                    return true; // Returns true when there is a any node of fertile land which is not visited.
                }
            }
        }
        return false; // Returns false when there are no nodes of the fertile land which are not visited.
    }

    //Calculates the FertileLands Area and returns a sorted list of areas.
    public List<Integer> calculateFertileLandArea() {
        int fertileFieldId = 0;
        //Breadth-First Traversal Algorithm
        while (true) {

            if (queue.isEmpty()) { //Enter this condition,when-ever u start to traverse a new fertile land.
                if(!getFertileFieldStartNode()) break;//checks if getFertileFieldStartNode method returns true or false
                fertileFieldId++;// Incremented when ever a new fertile field is found.
                fertileAreaMap.put(fertileFieldId, 0);//create a entry for the fertileField and its area.
                queue.add(startNode);//Add the very-first node of the fertile-land to Q.

            }
            if (!queue.isEmpty()) {
                int[] setNode = queue.remove();//pop the front node in the queue.
                addAdjacentNodesToQ(fertileFieldId,setNode);//add all the relevant adjacent nodes and increment the area accordingly.
            }

        }
        //Sorting the areas for the fertile lands.
        Iterator<Integer> iterator = fertileAreaMap.values().iterator();
        List<Integer> areas = new ArrayList<Integer>();
        while(iterator.hasNext()){
            areas.add(iterator.next());
        }
        Collections.sort(areas);
        return areas;

    }

    private void addAdjacentNodesToQ(int fertileFieldId, int[] setNode) {

        int[] rAdjNode,lAdjNode,uAdjNode,dAdjNode;
        int area;
        int x = setNode[0];
        int y = setNode[1];

        if (fieldMatrix[x][y] == 0) {
            if (x < LENGTH - 1) { //Checking for the right node.
                rAdjNode = new int[]{x + 1, y};//Right adjacent node
                if (fieldMatrix[x + 1][y] == 0) {
                    queue.add(rAdjNode);
                }
            }
            if (x >= 1) {//Checking for the left node
                lAdjNode = new int[]{x - 1, y};//Left adjacent node
                if (fieldMatrix[x - 1][y] == 0) {
                    queue.add(lAdjNode);
                }
            }
            if (y < WIDTH - 1) {//Checking for the top node
                uAdjNode = new int[]{x, y + 1};//Upper adjacent node
                if (fieldMatrix[x][y + 1] == 0) {
                    queue.add(uAdjNode);
                }
            }
            if (y >= 1) {//Checking for the bottom node
                dAdjNode = new int[]{x, y - 1};//Lower adjacent node
                if (fieldMatrix[x][y - 1] == 0) {
                    queue.add(dAdjNode);
                }
            }
            fieldMatrix[x][y] = 1;//marking the fertileLand as covered.
            area = fertileAreaMap.get(fertileFieldId)+1;//increment the area by 1,every-time we traverse a fertile node.(gets the value and increments)
            fertileAreaMap.put(fertileFieldId, area);//save the FertileFieldId and its corresponding area //
            //Here we are over riding the previous area associated with the FertilFieldId.
        }
    }


    public void readInput() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter the BarrenRectangles Input: \n");
        String input = in.nextLine();
        String[] args = input.replaceAll("[{}]","").replaceAll("[\"]","").split(",");
        parseInput(args);

    }


    public void parseInput(String[] args) throws Exception {
        Rectangle r;
        if(args.length==0){
            throw new Exception("Please pass some arguments");
        }
        for (int i = 0; i < args.length; i++) {
            validate(args[i]);
            String[] array = args[i].split(" ");
            int[] lowerLeftNode = {Integer.parseInt(array[0]), Integer.parseInt(array[1])};
            int[] upperRightNode = {Integer.parseInt(array[2]), Integer.parseInt(array[3])};
            r = new Rectangle(lowerLeftNode, upperRightNode);
            barrenRectangles.add(r);
        }
    }

    public void markBarrenLand() { //Marking the Barren Land, setting the node to 1
        for (Rectangle r : barrenRectangles) {
            for (int i = r.lowerLeftNode[0]; i <= r.upperRightNode[0]; i++) {
                for (int j = r.lowerLeftNode[1]; j <= r.upperRightNode[1]; j++) {
                    fieldMatrix[i][j] = 1;
                }
            }
        }
    }


    //Utility method to clear the fieldMatrix.
    public void resetMatrix() {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                fieldMatrix[i][j] = 0;
            }
        }
    }

    private void validate(String arg) throws Exception {
        String[] array = arg.split(" ");
        if(array.length!=4){
            throw new Exception("Invalid no of arguments: "+arg);
        }
        if(!containsAllIntegers(array)){
            throw new Exception("Argument has/have invalid type(not Integer) :"+arg);
        }
        if(array.length==4){
            if(Integer.parseInt(array[0])>Integer.parseInt(array[2])){
                throw new Exception("x co-ordinates are wrongly aligned :"+arg);
            }
            if(Integer.parseInt(array[1])>Integer.parseInt(array[3])){
                throw new Exception("y co-ordinates are wrongly aligned "+arg);
            }
        }

    }


    public static boolean containsAllIntegers(String[] integers){
        //loop over the array; if any value isnt an integer return false.
        for (String integer : integers){
            if (!isInteger(integer)){
                return false;
            }
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public void printGrid() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                System.out.print(fieldMatrix[j][i] + "");
            }
            System.out.print("\n");
        }
    }

}