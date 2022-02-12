import java.util.*;
import java.io.*;

public class DSAGraphTestHarness
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();
        DSAGraph fileGraph = new DSAGraph();


        System.out.println("Adding vertex A");
        graph.addVertex("A");
        System.out.println("Adding vertex B");
        graph.addVertex("B");
        System.out.println("Adding vertex C");
        graph.addVertex("C");
        System.out.println("Adding vertex D");
        graph.addVertex("D");
        System.out.println("Adding vertex E");
        graph.addVertex("E");

        System.out.println("Adding edge from A to D");
        graph.addEdge("A", "D");
        System.out.println("Adding edge from A to E");
        graph.addEdge("A", "E");
        System.out.println("Adding edge from B to C");
        graph.addEdge("B", "C");
        System.out.println("Adding edge from B to D");
        graph.addEdge("B", "D");
        System.out.println("Adding edge from B to E");
        graph.addEdge("B", "E");
        System.out.println("Adding edge from C to D");
        graph.addEdge("C", "D");
        System.out.println("Adding edge from C to E");
        graph.addEdge("C", "E");
        System.out.println("Adding edge from E to D");
        graph.addEdge("E", "D");
 
        System.out.println("\nDisplaying as adjacency list:- ");
        graph.displayAsList();

        System.out.println("\nNumber of Vertices are: " + graph.getVertexCount());
        System.out.println("Number of Edges are: " + graph.getEdgeCount());
        System.out.println("\nDoes graph has vertex with label \"C\" ?");

        if(graph.hasVertex("C"))
            System.out.println("Graph has vertex \"C\".");
        else
            System.out.println("Graph doesn't have vertex \"C\".");

        System.out.println("\nDoes graph has vertex with label \"G\" ?");

        if(graph.hasVertex("G"))
            System.out.println("Graph has vertex \"G\".");
        else
            System.out.println("Graph doesn't have vertex \"G\".");


        System.out.println("\nDisplaying as matrix:- \n");
        graph.displayAsMatrix();

        System.out.println("\nCreating a graph from file (USING FILEIO):-\n");
        String filename = "prac6.al";
        fileGraph = readFile(filename);
       
        System.out.println("\nDisplaying as adjacency list:- ");
        fileGraph.displayAsList();

        System.out.println("\nNumber of vertices: " + fileGraph.getVertexCount());
        System.out.println("Number of Edges are: " + fileGraph.getEdgeCount());

        System.out.println("\nDoes graph has vertex with label \"B\" ?");
        if(graph.hasVertex("B"))
            System.out.println("Graph has vertex \"B\".");
        else
            System.out.println("Graph doesn't have vertex \"B\".");

        System.out.println("\nDoes graph has vertex with label \"M\" ?");
        if(graph.hasVertex("M"))
            System.out.println("Graph has vertex \"M\".");
        else
            System.out.println("Graph doesn't have vertex \"M\".");


        System.out.println("\nDisplaying as matrix:- \n");
        fileGraph.displayAsMatrix(); 
        
}
    public static DSAGraph readFile(String inFileName)
    {
        DSAGraph graph = new DSAGraph();
    
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        try
        {
            fileStream = new FileInputStream(inFileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                lineNum++;
                processLine(line, graph);
                line = bufRdr.readLine();
            }

            fileStream.close();
        }
        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {}
            }
            System.out.println("Error in fileProcessing: " + e.getMessage());
        }
        return graph;
    } 

    private static void processLine(String spaceRow, DSAGraph graph)
    {
        String[] splitLine;
        splitLine = spaceRow.split(" ");
        System.out.println("Edge vertex 1: " + splitLine[0] + " Edge vertex 2: " + splitLine[1]);       
        graph.addVertex(splitLine[0]);
        graph.addVertex(splitLine[1]);
        graph.addEdge(splitLine[0], splitLine[1]);
 
    }
}
