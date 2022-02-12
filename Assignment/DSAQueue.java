/************************************************************************
* Name: DSAQueue.java                                                   *
* Author: Muskan Vig                                                    *
* Date created: 10 October 2020                                         *
* Date modified: 10 October 2020                                        *
* Purpose: Implements Queue ADT.                                        *
* reference: taken from submitted practical-5 (Linked List).            *
*************************************************************************/

import java.util.*;

public class DSAQueue implements Iterable
{
    private DSALinkedList queue = new DSALinkedList();
   
    public Iterator iterator()
    {
        return queue.iterator();
    }

    /****************************************************************
    * Name: isEmpty
    * Imports: none
    * Export: boolean
    * Purpose: Returns true if queue is empty.
    ***************************************************************/

    public boolean isEmpty()
    {
       return queue.isEmpty();
    }

    /****************************************************************
    * Name: enqueue
    * Imports: value(Object)
    * Export: none
    * Purpose: Inserts imported value at the last of the queue.
    ***************************************************************/

    public void enqueue(Object value)
    {
        queue.insertLast(value);
    }

    /****************************************************************
    * Name: dequeue
    * Imports: none
    * Export: frontVal(Object)
    * Purpose: Returns starting value of the queue and removes it.
    *****************************************************************/

  
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
}//End DSAQueue
