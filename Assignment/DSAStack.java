/************************************************************************
* Name: DSAStack.java                                                   *
* Author: Muskan Vig                                                    *
* Date created: 10 September 2020                                       *
* Date modified: 01 October 2020                                        *
* Purpose: Implementation of Stack ADT.                                 *
* Reference: Taken from submitted prac-4 Linked List.                   *
*************************************************************************/

import java.util.*;

public class DSAStack implements Iterable 
{
    private DSALinkedList stack = new DSALinkedList();
    
    public Iterator iterator()
    {
        return stack.iterator();  
    }

    /****************************************************************
    * Name: push
    * Imports: value(Object)
    * Export: none
    * Purpose: pushes the imported value on top of stack.
    ***************************************************************/


    public void push(Object value)    
    {
        stack.insertFirst(value);
    }

    /****************************************************************
    * Name: isEmpty
    * Imports: none
    * Export: boolean
    * Purpose: returns true if stack is empty.
    ***************************************************************/


    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    /******************************************************************************
    * Name: pop
    * Imports: none
    * Export: topVal(Object) 
    * Purpose: returns top value from stack and deletes the item on top of stack.
    ********************************************************************************/


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

}//End DSAStack

