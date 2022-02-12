import java.util.*;
public class DSAShufflingQueue extends DSAQueue
{
    public DSAShufflingQueue()
    {
        super();         
    }

    public DSAShufflingQueue(int maxCapacity)
    {
        super(maxCapacity);
    } 

    public void enqueue(Object value)
    {
        if(isFull())
            throw new IllegalArgumentException("Queue is full. Aborting!");
        else
        {
            queue[count] = value;   
            count++;
        }
    
    }

    public Object dequeue()
    {
        Object frontValue = peek();
        count--;

        for(int ii=0; ii<count; ii++)
        {
            queue[ii] = queue[ii+1];

        }
        
        return frontValue;
    } 
}
