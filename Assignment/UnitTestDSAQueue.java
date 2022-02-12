/***********************************************************************
* Name: UnitTestDSAQueue.java
* Author: Muskan Vig
* Date created: 10 September 2020
* Date modified: 10 September 2020
* Purpose: Unit test for class DSAQueue
************************************************************************/

import java.util.*;

public class UnitTestDSAQueue
{

    public static void main(String[] args)
    {
        DSAQueue q1 = new DSAQueue();
    
        System.out.println("\nUnit testing for DSAQueue class: \n");

        System.out.println("Enqueuing 10");
        q1.enqueue(10);
        System.out.println("Enqueuing 20");
        q1.enqueue(20);
        System.out.println("Enqueuing 30");
        q1.enqueue(30);
        System.out.println("Enqueuing 40");
        q1.enqueue(40);
        System.out.println("Enqueuing 50");
        q1.enqueue(50);
        System.out.println("Enqueuing 60");
        q1.enqueue(60);
        System.out.println("Enqueuing 70");
        q1.enqueue(70);

        System.out.println("Dequeuing: " + q1.dequeue());
        System.out.println("Dequeuing: " + q1.dequeue());
        System.out.println("Dequeuing: " + q1.dequeue());

        System.out.println("Enqueuing 80");
        q1.enqueue(80);
        System.out.println("Enqueuing 90");
        q1.enqueue(90);

        System.out.println("Dequeuing: " + q1.dequeue());

        System.out.println("Enqueuing 100");
        q1.enqueue(100);

        System.out.println("Iterating over queue");

        iterateOverQueue(q1);
       
        System.out.println();
    }

    //iterator
    public static void iterateOverQueue(DSAQueue queue)
    {
        Iterator iter = queue.iterator();
        
        while(iter.hasNext())
        {
            System.out.print(iter.next() + " ");
        }
    }
}//End UnitTestDSAQueue
