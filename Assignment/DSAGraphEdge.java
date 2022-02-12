/****************************************************************************
* Name: DSAGraphEdge.java                                                   *
* Author: Muskan Vig                                                        *
* Date created: 20 October 2020                                             *
* Date modified: 20 October 2020                                            *
* Purpose: Edge class stores edges and its weight which is further used     *
* in graph data structure.                                                  *
****************************************************************************/

import java.util.*;
import java.io.*;

public class DSAGraphEdge implements Serializable
{
    DSAGraphVertex from;
    DSAGraphVertex to;
    String label;
    Object value;

    //constructor
    public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel, Object inValue)
    {
        from = fromVertex;
        to = toVertex;
        label = inLabel;
        value = inValue;
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


    //getter
    public DSAGraphVertex getFrom()
    {
        return from;
    }

    //getter
    public DSAGraphVertex getTo()
    {
        return to;
    }

    /********************************************************************************
    * Name: isDirected
    * Imports: none
    * Export: directed(boolean)
    * Purpose: Returns false if an edge is not directed (i.e if it is bidirectional.
    **********************************************************************************/

    public boolean isDirected()
    {
        boolean directed = true;
        Iterator list1 = from.edgeList.iterator(); //get edges lists
        Iterator list2 = to.edgeList.iterator();
        String label1 = to.label;
        String label2 = from.label;
        boolean found1 = false;
        boolean found2 = false;
        while(list1.hasNext()) 
        { //check if list1 contains the label of 'to' vertex
            String curr = ((DSAGraphEdge)(list1.next())).to.label;
            if(curr.equals(label1))
                found1 = true;
        }

        //repeat for iterating list 2 to find label of 'from' vertex

        while(list2.hasNext()) 
        { //check if list2 contains the label of 'to' vertex
            String curr = ((DSAGraphEdge)(list2.next())).to.label;
            if(curr.equals(label2))
                found2 = true;
        } 

        if(found1 && found2) //labels found in each other's adjacency lists
            directed = false;

        return directed;               
    }

    /*******************************************************************
    * Name: toString
    * Imports: none
    * Export: String
    * Purpose: returns label of the edge which is helpful in outputting
    * edge information. 
    *********************************************************************/

    public String toString()
    {
        return label;
    }

    /*****************************************************************************
    * Name: equals
    * Imports: o(Object)
    * Export: equal(boolean)
    * Purpose: Checks if parsed object has same reference address and label.
    ******************************************************************************/

    public boolean equals(Object o) 
    {
        boolean equal = false;

        DSAGraphEdge other = (DSAGraphEdge)o;
        //check reference address and labels
        if(this == other || this.label == other.label) 
            equal = true;
        else if(this.value.equals(other.value)) 
            equal = true;
        else
            equal =  false;
        return equal;
    }
}//End DSAGraphEdge
