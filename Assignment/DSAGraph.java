/************************************************************************************************
* Name: DSAGraph.java                                                                           *
* Author: Muskan Vig                                                                            *
* Date created: 10 October 2020                                                                 *
* Date modified: 25 October 2020                                                                *
* Purpose: This class is the implementation of graph data structure which is quite useful       *
* in many applications.                                                                         *
* This graph is implemented with Vertex and Edge classes. Edges store weight as well.           *
* Reference: Parts except edge implementation are from my submitted practical-6 (Graphs).       *.
*************************************************************************************************/


import java.util.*;
import java.io.*;

public class DSAGraph implements Serializable
{
    private DSALinkedList vertices;
    private DSALinkedList edges;

    //Constructor
    public DSAGraph()
    {      
        vertices = new DSALinkedList();  
        edges = new DSALinkedList();
    }

    //Serialization
    public void save(DSAGraph objToSave, String filename)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(this);

            objStrm.close();
        }
        catch(Exception e) 
        {
            throw new IllegalArgumentException("Unable to save object to file.");
        }
    }//End save.

    //deserialization.
    public DSAGraph load(String filename) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSAGraph inObj = new DSAGraph();

        try
        {
            fileStrm = new FileInputStream(filename);
            objStrm = new ObjectInputStream(fileStrm);
            inObj = (DSAGraph) objStrm.readObject();
            objStrm.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Class DSAGraph not found " + e.getMessage());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }
        return inObj;
    }//End load.


    /***********************************************************************************
    * Name: addVertex
    * Imports: label(String), value(Ibject)
    * Export: none
    * Purpose: Adds vertex with imported label and stores imported data in the graph.
    *************************************************************************************/

    public void addVertex(String label, Object value)
    {
        DSAGraphVertex vertex = new DSAGraphVertex(label, value);

        if((vertices == null) || (getVertex(label) == null))
            vertices.insertLast(vertex);

    }

    /****************************************************************************************
    * Name: addEdge
    * Imports: label1(String), label2(String), value(Object)
    * Export: none
    * Purpose: Adds edge between the imported vertices label with a new edge label and 
    * stores weight in the edge.
    ******************************************************************************************/


    public void addEdge(String label1, String label2, String edgeLabel, Object value)
    {
        DSAGraphVertex v1 = getVertex(label1);
        DSAGraphVertex v2 = getVertex(label2);

        DSAGraphEdge e = new DSAGraphEdge(v1, v2, edgeLabel, value);        
       
        if((edges == null) || getEdge(edgeLabel) == null)
        { 
            v1.addEdge(e);
            edges.insertLast(e);
       }   
    }

    /******************************************************************
    * Name: hasVertex
    * Imports: label(String)
    * Export: found(boolean)
    * Purpose: Returns true if a vertex with imported label exists.
    *******************************************************************/


    public boolean hasVertex(String label)
    {
        boolean found = false;

        if(getVertex(label) != null)
        {
            found = true;
        }

        return found;
    }

    /*********************************************************
    * Name: hasEdge
    * Imports: label(String)
    * Export: found(boolean)
    * Purpose: Checks if an edge with imported label exists.
    **********************************************************/


    public boolean hasEdge(String label)
    {
        boolean found = false;

        if(getEdge(label) != null)
        {
            found = true;
        }

        return found;
    }

    /******************************************************************************
    * Name: displayVertex
    * Imports: label(String)
    * Export: none
    * Purpose: Displays the information regarding the vertex with imported label.
    ********************************************************************************/

    public void displayVertex(String label)
    {
        System.out.println("\nAsset found is: " + label);
        System.out.println("Other assets it trades to (adjacent assets) are as follows:- \n");
        DSALinkedList adjacentList = getVertex(label).getAdjacentE();
        Iterator iter = adjacentList.iterator();

        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }

    /********************************************************************************
    * Name: displayEdge
    * Imports: label(String)
    * Export: none
    * Purpose: Displays label and weight (data) regarding edge with imported label.
    **********************************************************************************/

    public void displayEdge(String label)
    {
        System.out.println("Trade found is: " + getEdge(label).label);
        System.out.println("Trade details are as follows:-\n");
        System.out.println(getEdge(label).value.toString());
    }

    /*********************************************************
    * Name: getVertexCount
    * Imports: none
    * Export: count(int)
    * Purpose: Returns the number of vertices in the graph.
    **********************************************************/


    public int getVertexCount()
    {
        Iterator iter = vertices.iterator();
        int count = 0;

        while(iter.hasNext())
        {
            DSAGraphVertex n = (DSAGraphVertex)iter.next();

            count++;
        }

        return count;
    }

    /*******************************************************
    * Name: getEdgeCount
    * Imports: none
    * Export: count(int)
    * Purpose: Returns the number of edges in the graph.
    ********************************************************/


    public int getEdgeCount()
    {
        Iterator iter = edges.iterator();
        int count = 0;

        while(iter.hasNext())
        {
            DSAGraphEdge e = (DSAGraphEdge)iter.next();

            count++;
        }

        return count;
    }

    /***************************************************************************************
    * Name: getVertex
    * Imports: label(String)
    * Export: vertex(DSAGraphVertex)
    * Purpose: Helping method to ensure that a unique vertex is being added to the graph.
    *****************************************************************************************/

    public DSAGraphVertex getVertex(String label)
    {
        Iterator iter = vertices.iterator();
        DSAGraphVertex vertex = null;

        while(iter.hasNext()) 
        { 
            DSAGraphVertex temp = (DSAGraphVertex)iter.next(); 

            if(temp.label.equals(label))    
            {
                vertex = temp;
            }
        }

        return vertex;
    }

    /************************************************************************************
    * Name: getEdge
    * Imports: label(String)
    * Export: edge(DSAGraphEdge)
    * Purpose: Helping method to ensure that a unique edge is being added to the graph.
    **************************************************************************************/

    public DSAGraphEdge getEdge(String label)
    {
        Iterator iter = edges.iterator();
        DSAGraphEdge edge = null;

        while(iter.hasNext()) 
        { 
            DSAGraphEdge temp = (DSAGraphEdge)iter.next(); 

            if(temp.label.equals(label))    
            {
                edge = temp;
            }
        }

        return edge;
    }

    /************************************************************************
    * Name: getAdjacent
    * Imports: label(String)
    * Export: vertexList(DSALinkedList)
    * Purpose: It returns the list of adjacent vertices of imported label.
    *************************************************************************/

    public DSALinkedList getAdjacent(String label)
    {
        DSALinkedList vertexList;
        vertexList = getVertex(label).getAdjacent();
        return vertexList;
    }

    /*****************************************************************
    * Name: getAdjacentE
    * Imports: label(String)
    * Export: edgesList(DSALinkedList)
    * Purpose: It returns the edge list of imported label vertex's.
    *******************************************************************/


    public DSALinkedList getAdjacentE(String label)
    {
        DSALinkedList edgesList;
        edgesList = getVertex(label).getAdjacentE();
        return edgesList;
    }

    /*****************************************************************************
    * Name: isAdjacent
    * Imports: label1(String), label2(String)
    * Export: found(boolean)
    * Purpose: Checks if two vertices with imported label are adjacent or not.
    *******************************************************************************/


    public boolean isAdjacent(String label1, String label2)
    {
        String edgeLabel = label1 + label2;
        boolean found = false;

        if(hasEdge(edgeLabel))
            found = true;

        return found;
    }

    /****************************************************************
    * Name: display()
    * Imports: none
    * Export: none
    * Purpose: Wrapper method to aid in displaying functionality.
    *****************************************************************/


    //Wrapper method
    public void display()
    {
        displayAsList(vertices, "\n");

    }

    //Wrapper method
    public void displayEdges()
    {
        displayAsList(edges, "\n"); 
    }

    /**************************************************************
    * Name: displayAsList
    * Imports: list(DSALinkedList), append(String)
    * Export: none
    * Purpose: Iterate over imported list and displays it.
    ***************************************************************/


    public void displayAsList(DSALinkedList list, String append)
    {  int count = 0 ;
        Iterator iter = list.iterator();      
        while(iter.hasNext())
        {
            System.out.print(iter.next().toString() + append);
            count++;
        }        
        System.out.println("");
    }

    /*****************************************************
    * Name: vertexEdgeList
    * Imports: none
    * Export: none
    * Purpose: Displays alll the vertices' edge list.
    *****************************************************/

    public void vertexEdgeList()
    {  
        Iterator iter = vertices.iterator();
        while(iter.hasNext()) 
        {
            DSAGraphVertex vertex = (DSAGraphVertex) iter.next();
        
            System.out.print(vertex.label + "  ");

            DSALinkedList verEdgeList = vertex.getAdjacentE();

            displayAsList(verEdgeList ," ");

        }
    }

    //wrapper method
    public void displayE()
    {
        displayData(edges);
    }

        
    /*************************************************************************
    * Name: displayData
    * Imports: edges(DSALinkedList)
    * Export: none
    * Purpose: displays all the edges in graph's information.
    ***************************************************************************/

    public void displayData(DSALinkedList edges)
    {
        Iterator iter = edges.iterator();

        while(iter.hasNext())
        {
            DSAGraphEdge e = (DSAGraphEdge)iter.next();
            System.out.println(e.value.toString() + "\n");
        }
    }

    /**********************************************************************
    * Name: breadthFirstSearch
    * Imports: none
    * Export: none
    * Purpose: Traverses the graph using breadth first search algorithm.
    ************************************************************************/

    public void breadthFirstSearch()
    {
        int count = 0;
        
        //create queue
        DSAQueue queue = new DSAQueue();
        //get starting vertex
        Iterator iterV = vertices.iterator();
        iterV = edges.iterator(); //get first vertex from edges
        DSAGraphVertex current = ((DSAGraphEdge)iterV.next()).from;

        //enqueue starting vertex
        queue.enqueue(current);
        //set current to visited
        current.setVisited();
        
        //loop while queue isn't empty
        while(!queue.isEmpty())
        {
            //get dequeued vertex
            DSAGraphVertex v = (DSAGraphVertex)queue.dequeue();
            //set to visited
            v.setVisited();
    
            System.out.println(v.label);
            //get String adjacency list of vertex
            DSALinkedList adjacent = v.getAdjacent(); //gets list of vertices
            Iterator iter = adjacent.iterator();
            //parse adjacency list
            while(iter.hasNext())
            {
                v = (DSAGraphVertex)iter.next();
               //if vertex is NOT visited, enqueue
                if(!v.getVisited())
                    queue.enqueue(v);       
            }
            count++;
        }
       
        System.out.println("Count: " + count);

    }

    //filter method to filter out vertices
    public void filter(String name)
    {
        Iterator iter = edges.iterator();
 
        System.out.println("Assets (filter), trades including " + name + " are:- \n");
        while(iter.hasNext())
        {
            DSAGraphEdge e = (DSAGraphEdge)iter.next();

            if(e.from.label.equals(name) || e.to.label.equals(name))
                System.out.println(e.label);
        }         
    }

    //Implementation on getting top 10 trades based on count value of edge's object.

/*    public void tradeSort()
    {
        Iterator iter = edges.iterator();

        DSALinkedList sorted = new DSALinkedList();
        sorted.insertFirst((DSAGraphEdge)iter.next());

        while(iter.hasNext()) 
        {
            DSAGraphEdge e = (DSAGraphEdge) iter.next();
            DSAGraphEdge end = sorted.getLast();

            if(sorted.getCount() < 10) 
            {
                insert(sorted, e); //does insertion sort
            } //check if value should be in top 10
            else if(e.value.volume > end.value.volume) 
            {
                insert(sorted, e); //does insertion sort
                sorted.removeLast();
            }
        }        
    } */


    /*******************************************************************
    * Name: depthFirstSearch
    * Imports: none
    * Export: none
    * Purpose: Traverses the graph using depth first search algorithm.
    *********************************************************************/
    public void depthFirstSearch()
    {
         DSAStack stack = new DSAStack();
         int count = 0;

         Iterator iterV = vertices.iterator();
         iterV = edges.iterator(); //get first vertex from edges
         DSAGraphVertex current = ((DSAGraphEdge)iterV.next()).from;

         current.setVisited();
           
         stack.push(current);
         DSAGraphVertex v = current;

         while(!stack.isEmpty())
         {
             v = (DSAGraphVertex) stack.pop();
             stack.push(v);
             iterV = v.getAdjacent().iterator();

             while(iterV.hasNext())
             {
                 v = (DSAGraphVertex)iterV.next();

                 if(v.getVisited() != true)
                 {
                     DSALinkedList adjacent = v.getAdjacent(); //gets list of vertices
                     Iterator iter = adjacent.iterator();

                     iterV = v.getAdjacent().iterator();

                     stack.push(v);
                     v.setVisited();

                }
    
            }

            v = (DSAGraphVertex)stack.pop();
            count++;
        }
        System.out.println("count: " + count);
    }

    /**************************************************
    * Name: displayAsMatrix
    * Imports: none
    * Export: none
    * Purpose: Displays the graph as adjacent matrix.
    ***************************************************/


    public void displayAsMatrix()
    {
        DSALinkedList v1 = vertices;
        DSALinkedList v2 = vertices;    

        Iterator iter1 = v1.iterator();
        Iterator iter2 = v2.iterator();

        int matrix[][]= new int[getVertexCount()][getVertexCount()]; 

        
        for(int i = 0; i < matrix.length; i++) 
        {
            DSAGraphVertex vertex1 = (DSAGraphVertex)iter1.next();
            iter2 = v2.iterator();

            for(int j = 0; j < matrix.length; j++) 
            {
                DSAGraphVertex vertex2 = (DSAGraphVertex)iter2.next();
                if(isAdjacent(vertex1.label, vertex2.label))
                    matrix[i][j] = 1;
            }
        }

        iter1 = v1.iterator();
        
        System.out.print(" ");

        for(int i = 0; i < matrix.length; i++) 
        {
            System.out.print(" " + ((DSAGraphVertex)iter1.next()).label);
        }

        System.out.println();
        iter1 = v1.iterator();

        for(int x = 0; x < matrix.length; x++)
        {
        
            DSAGraphVertex v = (DSAGraphVertex)iter1.next();            

            for(int y = 0; y < matrix.length; y++)
            {

                if(y == 0)
                {
                    System.out.print(v.label);
                }
                System.out.print(" " + matrix[x][y]);
            }
            System.out.println();
        }
          //Call for Warshall algorithm.
          transitiveClosure(matrix);
    } 

    /***********************************************************************************************************
    * Name: transitiveClosure
    * Imports: graph[][](int array)
    * Export: none
    * Purpose: Checks if one node of the graph is reachable from another node (If indirect path exists).
    **************************************************************************************************************/

    public void transitiveClosure(int graph[][])
    {
        //Matrix with result if indirect path is there or not.
        int reach[][] = new int[getVertexCount()][getVertexCount()];
        int  i, j, k;

        for (i = 0; i < getVertexCount(); i++)
            for (j = 0; j < getVertexCount(); j++)
                reach[i][j] = graph[i][j];
 
       for (k = 0; k < getVertexCount(); k++)
        {
            // Get all vertices as source
            for (i = 0; i < getVertexCount(); i++)
            {
                // get all vertices as destination for the vertex in outer loop
                for (j = 0; j < getVertexCount(); j++)
                {
                    //Warshall (transitive closure) algorithm.
                    if((reach[i][j]!=0) || ((reach[i][k]!=0) && (reach[k][j]!=0)))
                    {
                        reach[i][j] = 1;
                    }
                    else
                        reach[i][j] = 0;
 
                }
            }
        }
 
        // Print the matrix
        printMatrix(reach);
    }

    /******************************************************
    * Name: printMatrix
    * Imports: reach(int[][])
    * Export: none
    * Purpose: Outputs matrix of transitive closure.
    *******************************************************/


    void printMatrix(int reach[][])
    {
        System.out.println("\nFollowing matrix is transitive closure"+
                           " of the given graph");
        for (int i = 0; i < getVertexCount(); i++)
        {
            for (int j = 0; j < getVertexCount(); j++) 
            {
                if ( i == j)
                  System.out.print("1 ");
                else
                  System.out.print(reach[i][j]+" ");
            }
            System.out.println();
        }
    } 

}//End DSAGraph
