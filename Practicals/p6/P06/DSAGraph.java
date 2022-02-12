import java.util.*;

public class DSAGraph
{
    private DSALinkedList vertices;

    public DSAGraph()
    {      
        vertices = new DSALinkedList();  
    }

    public void addVertex(String label)
    {
        DSAGraphVertex vertex = new DSAGraphVertex(label);

        if(vertices == null)
            vertices.insertLast(vertex);

        
        else if(getVertex(label) == null)
        {
            vertices.insertLast(vertex);     
        }
    }

    public void addEdge(String label1, String label2)
    {
        DSAGraphVertex v1 = getVertex(label1);
        DSAGraphVertex v2 = getVertex(label2);

        v1.links.insertLast(label2);
        v2.links.insertLast(label1);

    }

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

    public DSALinkedList getAdjacent(String label)
    {
        DSALinkedList adjacentList;
        adjacentList = getVertex(label).getAdjacent();
        return adjacentList;
    }

    public boolean isAdjacent(String label1, String label2)
    {
        DSALinkedList checkAdjacent = getAdjacent(label1);
        Iterator iter = checkAdjacent.iterator();
        boolean found = false;

        while(iter.hasNext())
        {
            String check = (String)iter.next();
            if(check.equals(label2))
                found = true;
        }

        return found;
    }

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

    public int getEdgeCount()
    {
        Iterator iter = vertices.iterator();
        int count = 0;

        while(iter.hasNext())
        {
            DSAGraphVertex vertex = (DSAGraphVertex)iter.next();
            Iterator iterList = vertex.links.iterator();
            while(iterList.hasNext())
            {
                String list = (String)iterList.next();
                count++;
            }
        }

        count /= 2;

        return count;
    }


    public boolean hasVertex(String label)
    {
        boolean found = false;

        if(getVertex(label) != null)
            found = true;

        return found;
    }

    public void displayAsList()
    {
        Iterator iter = vertices.iterator();      
        while(iter.hasNext())
        {
            System.out.println(iter.next().toString());
        }        
    }

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
    }
}
