import java.util.*;
public class DSAStack implements Iterable 
{
    private DSALinkedList stack = new DSALinkedList();
    
    public Iterator iterator()
    {
        return stack.iterator();  
    }

    public void push(Object value)    
    {
        stack.insertFirst(value);
    }
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    public Object pop()
    {
        Object topVal = stack.peekFirst();

        if(stack.isEmpty())

            throw new IllegalArgumentException("List is empty. Aborting!");
        else
        {
            stack.removeFirst();
        }
        return topVal;

    }

}

