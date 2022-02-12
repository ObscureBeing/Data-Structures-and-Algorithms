import java.util.*;
public class DSAStack
{
    protected Object[] stack;
    protected int count;
    public final int DEFAULT_CAPACITY = 100;

    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
        count = 0;
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
        if(count == stack.length)
            full = true;

        return full;
    }

    public void push(Object value)    //Object value so any datatype value can be stored.
    {
        if(isFull())
            throw new IllegalArgumentException("Stack is full, can not add.Aborting!");
        else
        {
            stack[count] = value;
            count = count + 1;
        }
    }

    public Object pop()
    {
        Object topVal = top();
        count = count - 1;
        return topVal;
    }

    public Object top()
    {
        Object topVal;
    
        if(isEmpty())
            throw new IllegalArgumentException("stack is empty. Aborting!"); 
        else
            topVal = stack[count-1];

        return topVal;       
    }

}

