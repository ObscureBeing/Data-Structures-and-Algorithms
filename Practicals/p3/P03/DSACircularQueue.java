import java.util.*;
public class DSACircularQueue extends DSAQueue
{
    public DSACircularQueue()
    {
        super();
    }


    public DSACircularQueue(int maxCapacity)
    {
        super(maxCapacity);
    }

    public boolean isEmpty()
    {
        boolean empty = false;
        
        if(count == 0)
            empty = true;
        
        return empty;
    }

    public boolean isFull()
    {
        boolean full = false;

        if((head == 0 && tail == queue.length) || (tail  == head && tail != 0 && head != 0))
            full = true;    

        return full;        
    }

    public void enqueue(Object value)
    {

        if(isFull())
            throw new IllegalArgumentException("Queue is full. Aborting!");
        else if((tail == queue.length) && (head != 0)) 
        {
            tail = 0;
            queue[tail] = value;
            tail++;
        }
        else
        {
            queue[tail] = value;
            tail++;
        }

        count++;
   }

    public Object dequeue() //should methods b private?
    {
        Object frontVal = peek();

        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty. Aborting!");
        else if(head == tail)
        {
            head = 0;
        }
        else if(head == queue.length-1)
        {
            head = 0;
        }
        else
        {
            head++;
        }
        
        count--;
        
        return frontVal;
    }

} 
