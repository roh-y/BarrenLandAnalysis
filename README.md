# BarrenLandAnalysis

First things first, get to know about the BFS, here is a great video presented by an MIT Professor, understanding BFS makes this case study a simple task.
[BFS By Erik Demaine](https://www.youtube.com/watch?v=s-CYnVz-uh4)

## Creating Fertile Land
Let us consider the fertile land on a graph sheet, a graph sheet is an 2-D space with X and Y co-ordinates. Now, create an matrix which can point to all the nodes in the graph using an 2-D array. I have created the array ### **int[][] fieldMatrix**.
Default values in the matrix are 0, considered as the fertile field.

|0|0|0|0|
|-------------|-------------:| -----:|-----:|
|0|0|0|0|
|0|0|0|0|
|0|0|0|0|
|0|0|0|0|
### This is an sample matrix which is considered to be fertile land.

## Marking the Barren Land
Second things second, user need to provide the co-ordinates of bottom left corner and top right corner of the barren land field which is in the form of rectangle, there can be multiple barren field inputs. All the rectangles of barren fields are stored in the **barrenRectangles**. So after knowing the co-ordinates of the barren fields the next thing I have done is marking the barren rectangles to 1.

Case1 :

|1|1|0|0|
|-------------|-------------:| -----:|-----:|
|1|1|0|0|
|1|1|0|0|
|1|1|0|0|
|0|0|0|0|

This is an sample matrix which is considered to be fertile land with one part of Barren Field which is marked as one.
The output of this case will be a single value.

Case 2 :

|1|1|1|1|
|-------------|-------------:| -----:|-----:|
|0|0|0|0|
|1|1|1|1|
|0|0|0|0|
|1|1|1|1|

This is an sample matrix which is considered to be fertile land with two part of Barren Field which is marked as one and they are divided by the barren land.
The output of this case will be two values i.e area of second row and area of fourth row.

## Finding the Area of Fertile Land
Using the **Breadth-First Search** the traversal of the nodes which are marked as zero is done and the area is found.

## Steps for Execuition
IDE - [IntelliJ IDEA CE](https://www.jetbrains.com/idea/download/#section=mac)

Download the code: 
![https://www.jetbrains.com/idea/download/#section=mac](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")










