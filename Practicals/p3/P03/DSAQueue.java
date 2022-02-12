import java.util.*;
public abstract class DSAQueue
{
    protected Object queue[];
    protected int count;
    protected int head;
    protected int tail;
    public final int DEFAULT_CAPACITY = 100;
    
    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;      
        head = 0;
        tail = 0;  
    }

    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
        head = 0;
        tail = 0;
    }

    public int getCount()
    {
        return count;
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
        if(count == queue.length)
            full = true;

        return full;
    }

    public abstract void enqueue(Object value);
   
    public abstract Object dequeue();

    public Object peek()
    {
        Object endVal;

        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty. Aborting!");
        else
            endVal = queue[head];

        return endVal;

    }
    
}
