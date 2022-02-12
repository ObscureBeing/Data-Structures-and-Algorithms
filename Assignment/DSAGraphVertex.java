/****************************************************************************************
* Name: DSAGraphVertex.java                                                             *
* Author: Muskan Vig                                                                    *
* Date created: 7 October 2020                                                          *
* Date modified: 20 October 2020                                                        *
* Purpose: A class to implement vertex functionality of graph data structure.           *
* Reference: Taken from submitted practical-6 (Graphs) with some modifications          *
* to adjust Edge class implementation.                                                  *   
*****************************************************************************************/

import java.util.*;
import java.io.*;

public class DSAGraphVertex implements Serializable
{
    public String label;
    Object value;
    public DSALinkedList edgeList;
    boolean visited;

    //Constructor
    public DSAGraphVertex(String inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue;
        edgeList = new DSALinkedList();
        visited = false;
    }    

    //getter
    public String getLabel()
    {
        return label;
    }

    //getter
    public Object getValue()
    {
        return value;
    }

    /****************************************************************
    * Name: getAdjacent
    * Imports: none
    * Export: vertexList(DSALiinkedList)
    * Purpose: Returns adjacent vertex list.
    *****************************************************************/

    public DSALinkedList getAdjacent()
    {
        DSALinkedList vertexList = new DSALinkedList();
        Iterator iter = edgeList.iterator();

        while(iter.hasNext())
        {
            vertexList.insertLast(((DSAGraphEdge)iter.next()).to);
        }
        return vertexList;
    }

    /****************************************************************
    * Name: getAdjacentE
    * Imports: none
    * Export: edgeList(DSALinkedList
    * Purpose: Returns edge list of vertex.
    ***************************************************************/

    public DSALinkedList getAdjacentE()
    {
        return edgeList; 
    }

    /****************************************************************
    * Name: addEdge
    * Imports: e(DSAGraphEdge)
    * Export: none
    * Purpose: adds the imported edge in the edges list.
    ***************************************************************/

    public void addEdge(DSAGraphEdge e)
    {
        edgeList.insertLast(e);        
    }

    /********************************************************************
    * Name: setVisited
    * Imports: none
    * Export: none
    * Purpose: Helping method in traversal. Marks the vertex as visited.
    *********************************************************************/

    public void setVisited()
    {
        visited = true;
    }

    /****************************************************************************
    * Name: clearVisited
    * Imports: none
    * Export: none
    * Purpose: Helping method which clears the visited vertices and unmark them.
    ******************************************************************************/

    public void clearVisited()
    {
        visited = false;
    }

    /****************************************************************
    * Name: getVisited
    * Imports: none
    * Export: boolean visited
    * Purpose: Returns w=if the vertex has been visited or not.
    ***************************************************************/

    public boolean getVisited()
    {
        return visited;
    }

    /****************************************************************
    * Name: toString
    * Imports:none
    * Export: label(String)
    * Purpose: returns label of the vertex which will be helpul in 
    * outputting things regarding vertex.
    *****************************************************************/

    public String toString()
    { 
        return label;
                  
    }

}//End DSAGraphVertex
