import java.util.*;
public class DSAQueue implements Iterable
{
    private DSALinkedList queue = new DSALinkedList();
   
    public Iterator iterator()
    {
        return queue.iterator();
    }

    public boolean isEmpty()
    {
       return queue.isEmpty();
    }

    public void enqueue(Object value)
    {
        queue.insertLast(value);
    }
   
    public Object dequeue()
    {
        Object frontVal = queue.peekFirst();    
        
        if(queue.isEmpty())
            throw new IllegalArgumentException("Queue is empty. Aborting!");
        else
        {
            queue.removeFirst();
        }
        return frontVal;
    }
}
