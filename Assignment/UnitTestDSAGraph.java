/********************************************************************************************
* Name: UnitTestDSAGraph                                                                    *
* Author: Muskan Vig                                                                        *
* Date created: 8 October 2020                                                              *
* Date modified: 27 October 2020                                                            *
* Purpose: Unit testing for DSAGraph class. (Tests all the functionality of the class)      *
* reference: Some part is taken from submitted prac-6 (Graphs)                              *
*********************************************************************************************/

import java.util.*;
import java.io.*;

public class UnitTestDSAGraph
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();
    
        System.out.println("\nUnit testing for DSAGraph class (Tests DSAVertex and DSAEdge class too).");
        System.out.println("Tests all the functions of DSAGraph class\n");
    
        System.out.println("Adding vertex A");
        graph.addVertex("A", 10);
        System.out.println("Adding vertex B");
        graph.addVertex("B", 20);
        System.out.println("Adding vertex C");
        graph.addVertex("C", 30);
        System.out.println("Adding vertex D");
        graph.addVertex("D", 40);
        System.out.println("Adding vertex E");
        graph.addVertex("E", 50);

        System.out.println("Adding edge from C to B");
        graph.addEdge("C", "B", "CB", 100);
        System.out.println("Adding edge from C to E");
        graph.addEdge("C", "E", "CE", 200);
        System.out.println("Adding edge from D to A");
        graph.addEdge("D", "A", "DA", 300);
        System.out.println("Adding edge from D to B");
        graph.addEdge("D", "B", "DB", 500);
        System.out.println("Adding edge from D to C");
        graph.addEdge("D", "C", "DC", 3400);
        System.out.println("Adding edge from E to A");
        graph.addEdge("E", "A", "EA", 60);
        System.out.println("Adding edge from E to B");
        graph.addEdge("E", "B", "EB", 104);
        System.out.println("Adding edge from E to D");
        graph.addEdge("E", "D", "ED", 94);
        System.out.println("Adding edge from B to C");
        graph.addEdge("B", "C", "BC", 800);

       
        System.out.println("\nDisplaying Vertex list:- ");
        graph.display();
        System.out.println("\nDisplaying edges list:- ");
        graph.displayEdges();
        System.out.println("\nDisplaying edges list of each vertex:- ");
        graph.vertexEdgeList();
        System.out.println("\nNumber of Vertices are: (shoulbe be 5) " + graph.getVertexCount());
        System.out.println("Number of Edges are: (should be 9) " + graph.getEdgeCount());
        System.out.println("\nFinding vertex with label \"C\" ?");

        boolean found = graph.hasVertex("C");
        if(!found)
            System.out.println("This vertex doesn't exist");
        else
        {
            System.out.println("\"C\" vertex found");
            System.out.println("Displaying vertex information:-");
            graph.displayVertex("C");
        }

        System.out.println("\nFinding vertex with label \"Q\" ?");
        found = graph.hasVertex("Q");
        if(!found)
            System.out.println("This vertex \"Q\" doesn't exist");


        boolean hasEdge = graph.hasEdge("ED");
        if(!hasEdge)
            System.out.println("This edge \"ED\" doesn't exist");
        else
            graph.displayEdge("ED");

        hasEdge = graph.hasEdge("DE");
        if(!hasEdge)
            System.out.println("This edge \"DE\" doesn't exist");


        boolean isAdjacent = graph.isAdjacent("C", "E");
        if(isAdjacent)
            System.out.println("\n \"C\" is Adjacent to \"E\".\n");
        else
            System.out.println("\n\"C\" is Not adjacent to \"E\".\n");

        isAdjacent = graph.isAdjacent("E", "C");
        if(isAdjacent)
            System.out.println("\n\"E\" Is Adjacent to \"C\".\n");
        else
            System.out.println("\n\"E\" is Not adjacent to \"C\".\n");


        System.out.println("Testing adjacency matrix and then Warshall's algorithm: \n");
        graph.displayAsMatrix();

        System.out.println("Testing filter");
        graph.filter("C");
        System.out.println("Testing DFS:- \n");
        graph.depthFirstSearch();

        System.out.println("Testing serialization");
        graph.save(graph, "TestSerial.ser");
        System.out.println("\"TestSerial.ser\" successfully saved (serialized data). :))\n");
        //deserialize into new graph object for testing.
        DSAGraph loadG = new DSAGraph();
        loadG = loadG.load("TestSerial.ser");

        System.out.println("\"TestSerial.ser\" successfully loaded in graph's instance (serialized data). :))\n");
        System.out.println("\nDisplaying new graph objectis each vertex's edge list loaded from serialized object: \n");
        loadG.vertexEdgeList();
   
    }
}//End UnitTestDSAGraph
