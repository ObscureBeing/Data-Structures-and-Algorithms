import java.util.*;
public class DSACircularQueueTestHarness
{
    public static void main(String[] args)
    {
        DSACircularQueue q1 = new DSACircularQueue(7);

        
        System.out.println("Enqueuing 10");
        q1.enqueue(10);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
        System.out.println("Enqueuing 20");
        q1.enqueue(20);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
        System.out.println("Enqueuing 30");
        q1.enqueue(30);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
        System.out.println("Enqueuing 40");
        q1.enqueue(40);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
        System.out.println("Enqueuing 50");
        q1.enqueue(50);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
        System.out.println("Enqueuing 60");
        q1.enqueue(60);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
        System.out.println("Enqueuing 70");
        q1.enqueue(70);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);
 

        System.out.println("Dequeuing: " + q1.dequeue());
        System.out.println("head: " +q1.head + " , tail: " + q1.tail);

        System.out.println("Dequeuing: " + q1.dequeue());
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);

        System.out.println("Dequeuing: " + q1.dequeue());
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);

        System.out.println("Enqueuing 80");
        q1.enqueue(80);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);

        System.out.println("Enqueuing 90");
        q1.enqueue(90);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);

        System.out.println("Enqueuing 100");
        q1.enqueue(100);
        System.out.println("head: " + q1.head + " , tail: " + q1.tail);


       for(int i = 0; i < q1.queue.length; i++)
        {
            System.out.print(q1.queue[i] + " ");
        } 
 
        System.out.println();

   
/*        if(q1.tail >= q1.head) 
        {
            for(int i = q1.head; i < q1.tail; i++)
            {
                System.out.print(q1.queue[i] + " ");
            }
        } 
        else
        {
            for(int i = q1.head; i <= q1.queue.length; i++)
            {
                System.out.print(q1.queue[i] + " ");
            }
            for(int i = 0; i <= q1.tail; i++)
            {
                System.out.print(q1.queue[i] + " ");
            }

        }    */  

       /*  while(! q1.isEmpty())
        {
            Object n = q1.dequeue();
            System.out.print(n + " ");    
        }*/ 
 
    }
}
