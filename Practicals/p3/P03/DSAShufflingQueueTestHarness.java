import java.util.*;
public class DSAShufflingQueueTestHarness
{

    public static void main(String[] args)
    {
        DSAShufflingQueue q1 = new DSAShufflingQueue(5);

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

        for(int i=0; i<q1.queue.length; i++)
        {
            System.out.print(q1.queue[i] + " ");
        }
        System.out.println();

        System.out.println("Dequeuing: " + q1.dequeue());

        for(int i=0; i<q1.queue.length; i++)
        {
            System.out.print(q1.queue[i] + " ");
        }
        System.out.println();

        System.out.println("Dequeuing: " + q1.dequeue());

        for(int i=0; i<q1.queue.length; i++)          //try len instead of count.
        {
            System.out.print(q1.queue[i] + " ");
        }
        System.out.println();

        System.out.println("Enqueuing 60");
        q1.enqueue(60);
        System.out.println("Enqueuing 70");
        q1.enqueue(70);

       /* for(int i=0; i<q1.queue.length; i++)
        {
            System.out.print(q1.queue[i] + " ");
        } */

        while(! q1.isEmpty())
        {
            Object n = q1.dequeue();
            System.out.print(n + " ");    
        } 
        
        System.out.println();
    }
}
