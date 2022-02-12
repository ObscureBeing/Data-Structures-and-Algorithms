import java.util.*;
import java.io.*;
public class BinarySearchTreeTestHarness
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();       
        BinarySearchTree newTree = new BinarySearchTree();
        int choice;

        do 
        {
        System.out.println("Please select one of the following option: \n");
        System.out.println("1. read a CSV file");
        System.out.println("2. read a serialized file");
        System.out.println("3. display the tree");
        System.out.println("4. write a CSV file");
        System.out.println("5. write a serialized file");
        System.out.println("0. Exit\n");
        choice = sc.nextInt();

        switch(choice) 
        {
            case 1: String fileName = "tree.csv";     
                    tree = readFile(fileName);
                    System.out.println("Successfully read " + fileName + "\n");
                    System.out.println("\nDisplaying tree in Pre-order: \n");
                    tree.traverseTreePreorder();

                    System.out.println("\nHeight of the tree is: " + tree.height());
                    System.out.println("\nMinimum key is: " + tree.min());
                    System.out.println("Maximum key is: " + tree.max());

                    System.out.println("\nNumber of nodes: " + tree.count);
                    tree.balance();

                    System.out.println("\nTesting find - Value of key B is 20: " + tree.find("B"));
                    System.out.println("Testing find - Value of key G is 70: " + tree.find("G"));
                    System.out.println();

                    System.out.println("Deleting key \"A\"");
                    tree.delete("A");
                    System.out.println("Inorder traversal after deletion of \"A\"");
                    tree.traverseTreeInorder();
                    System.out.println("\n");

                    System.out.println("Deleting key \"G\"");
                    tree.delete("G");
                    System.out.println("Inorder traversal after deletion of \"G\"");
                    tree.traverseTreeInorder();
                    System.out.println("\n");

                    System.out.println("Deleting key \"F\"");
                    tree.delete("F");
                    System.out.println("Inorder traversal after deletion of \"F\"");
                    tree.traverseTreeInorder();
                    System.out.println("\n");                   
                    break;

            case 2: tree = readFile("tree.csv");
                    String file;
                    System.out.print("Enter the serialized file name:- ");
                    sc.nextLine();
                    file = sc.nextLine();
                    tree.save(tree, file); 
                    newTree = newTree.load(file);
                    System.out.println("\nReading serialized file " + file + " ....\nAfter loading saved tree in a new list :- \n");
                    newTree.traverseTreePreorder();
                    System.out.println();
                    break;

            case 3: System.out.println("Displaying tree in in-order");
                    tree.traverseTreeInorder();
                    System.out.println();
                    System.out.println("Displaying tree in pre-order");
                    tree.traverseTreePreorder();
                    System.out.println();
                    System.out.println("Displaying tree in post-order");
                    tree.traverseTreePostorder();
                    System.out.println();
                    break;

            case 4: int option;
                    System.out.println("Choose an option to write the file?\n");
                    System.out.println("\t1. inorder traversal");
                    System.out.println("\t2. preorder traversal");
                    System.out.println("\t3. postorder traversal");
                    option = sc.nextInt();

                    switch(option)
                    {
                        case 1: tree.writeInorder("inorder.csv");
                                System.out.println("Successfully written csv file \"inorder.csv\", In-order........:)\n"); 
                                break;
                        case 2: tree.writePreorder("preorder.csv");
                                System.out.println("Successfully written csv file \"preorder.csv\", Pre-order........:)\n"); 
                                break;
                        case 3: tree.writePostorder("postorder.csv");
                                System.out.println("Successfully written csv file \"postorder.csv\", Post-order........:)\n"); 
                                break;
                    }
                    break;

            case 5: String writeSerial;
                    System.out.print("Enter the name of serialized file to write: ");
                    sc.nextLine();
                    writeSerial = sc.nextLine();
                    tree.save(tree, writeSerial); 
                    System.out.println(".......Successfully written serialized file " + writeSerial + "......\n");
                    break;
        }
        }while(choice != 0);
    }

    public static BinarySearchTree readFile(String inFileName)
    {
        BinarySearchTree tree = new BinarySearchTree();
    
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        BinarySearchTree bst = new BinarySearchTree();
        try
        {
            fileStream = new FileInputStream(inFileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                lineNum++;
                processLine(line, tree);
                line = bufRdr.readLine();
            }

            fileStream.close();
        }
        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {}
            }
            System.out.println("Error in fileProcessing: " + e.getMessage());
        }
        return tree;
    } 

    private static void processLine(String csvRow, BinarySearchTree tree)
    {
        String[] splitLine;
        splitLine = csvRow.split(",");
        System.out.println("key: " + splitLine[0] + " value: " + splitLine[1]);
        tree.insert(splitLine[0], Integer.parseInt(splitLine[1]));
   
    }

}
