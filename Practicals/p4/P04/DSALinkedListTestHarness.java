import java.util.*;
public class DSALinkedListTestHarness
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        String filename = " ";
        DSALinkedList list = new DSALinkedList();
        DSALinkedList list2 = new DSALinkedList();

        System.out.println("Inserting first: 50");
        list.insertFirst(50);
        System.out.println("Inserting first: 40");
        list.insertFirst(40);
        System.out.println("Inserting first: 30");
        list.insertFirst(30);
        System.out.println("Inserting first: 20");
        list.insertFirst(20);
        System.out.println("Inserting first: 10");
        list.insertFirst(10);
        System.out.println("Inserting last: 100");
        list.insertLast(100);
        System.out.println("Inserting last: 200");
        list.insertLast(200);



        System.out.println("Peek first: " + list.peekFirst());
        System.out.println("Peek last: " + list.peekLast());

        System.out.println("\nRemoving first: 10 - " + list.removeFirst());
        System.out.println("Removing first: 20 - " + list.removeFirst());

        System.out.println("Peek first: " + list.peekFirst());
        System.out.println("Peek last: " + list.peekLast());


        System.out.println("\nRemoving last: 200 - " + list.removeLast());
        System.out.println("Removing last: 100 - " + list.removeLast());

        System.out.println("Peek first: " + list.peekFirst());
        System.out.println("Peek last: " + list.peekLast());

        System.out.println("\nInserting first: 750");
        list.insertFirst(750);
        System.out.println("Inserting first: 850");
        list.insertFirst(850);
        System.out.println("Inserting last: 930");
        list.insertLast(930);
        System.out.println("Inserting last: 320");
        list.insertLast(320);
 
        System.out.println("Peek first: " + list.peekFirst());
        System.out.println("Peek last: " + list.peekLast());


        System.out.println("\nIterating over list- ");
        iterateOverList(list);
        System.out.println();
    
        System.out.println("Menu:- \n1. Read a serialized file \n2. display the list \n3. write a serialized file");
        System.out.print("Enter the file name: ");

        filename = sc.nextLine();
        System.out.println("\nEnter your choice");
        choice = sc.nextInt();
    
        switch(choice)
        {
            case 1: list.save(list, filename);
                    System.out.println("List saved in " + filename);
                    break;
            case 2: list.save(list, filename);
                    list2 = list2.load(filename);
                    System.out.println("List loaded!");
                    System.out.println("List:- ");
                    iterateOverList(list2);
                    System.out.println();
                    break;
            case 3: list.save(list, filename);
                    list.load(filename);
                    System.out.println("List loaded");
                    break;
            default: System.out.println("Invalid choice!");
        }
        
   }
    public static void iterateOverList(DSALinkedList theList)
    {
        Iterator iter = theList.iterator();

        while(iter.hasNext())
        {
            System.out.print(iter.next() + " ");
        }
    }
}
