/***********************************************************************
* Name: UnitTestDSAStack.java
* Author: Muskan Vig
* Date created: 10 September 2020
* Date modified: 10 September 2020
* Purpose: Unit testing for DSAStack class
* Reference: Taken from practical 4 Linked list
************************************************************************/

import java.util.*;

public class UnitTestDSAStack
{
    public static void main(String[] args)
    {
        DSAStack s2 = new DSAStack();

        System.out.println("\nUnit testing for DSAStack class:\n");

        System.out.println("Pushing 10");
        s2.push(10);
        System.out.println("Pushing 20");
        s2.push(20);
        System.out.println("Pushing 30"); 
        s2.push(30);
        System.out.println("Pushing 40");
        s2.push(40);

        System.out.println("Item popped: " + s2.pop());
        System.out.println("Item popped: " + s2.pop());

        System.out.println("Pushing 50"); 
        s2.push(50);

        System.out.println("Item popped: " + s2.pop());

        System.out.println("Pushing 60");
        s2.push(60);
        System.out.println("Pushing 70");
        s2.push(70);
        System.out.println("Pushing 80"); 
        s2.push(80);
        System.out.println("Pushing 90"); 
        s2.push(90);

        System.out.println("Iterating over stack");

        iterateOverStack(s2);

        System.out.println();        

    }
    public static void iterateOverStack(DSAStack stack)
    {
        Iterator iter = stack.iterator();

        while(iter.hasNext())
        {
            System.out.print(iter.next() + " ");
        }
    }
}
