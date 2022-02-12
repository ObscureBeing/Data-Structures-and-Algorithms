import java.util.*;

public class DSAGraphVertex
{
    public String label;
    public DSALinkedList links;

    public DSAGraphVertex(String inLabel)
    {
        label = inLabel;
        links = new DSALinkedList();
    }    

    public String getLabel()
    {
        return label;
    }


    public DSALinkedList getAdjacent()
    {
        return links;
    }

    public void addEdge(DSAGraphVertex vertex)
    {
        links.insertLast(vertex.label);
    }

    public String toString()
    { 
        Iterator iter = links.iterator();
        String display = label + " -> ";

        while(iter.hasNext()) 
        {
            display += (String)iter.next() + " ";
        }
       
        return display;
    }

}
