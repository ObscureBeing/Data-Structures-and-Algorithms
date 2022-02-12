import java.util.*;
import java.io.*;

public class DSAHeapTestHarness
{
    public static void main(String[] args)
    {       
        System.out.println("Testing small data first:- :))\n");
        DSAHeap heap = new DSAHeap(30);
        
        System.out.println("Inserting key: 70 value: aA");
        heap.add(70, "aA");
        System.out.println("Inserting key: 40 value: bB");
        heap.add(40, "bB");
        System.out.println("Inserting key: 50 value: cC");
        heap.add(50, "cC");
        System.out.println("Inserting key: 20 value: dD");
        heap.add(20, "dD");
        System.out.println("Inserting key: 60 value: eE");
        heap.add(60, "eE");
        System.out.println("Inserting key: 100 value: fF");
        heap.add(100, "fF");
        System.out.println("Inserting key: 80 value: gG");
        heap.add(80, "gG");
        System.out.println("Inserting key: 30 value: hH");
        heap.add(30, "hH");
        System.out.println("Inserting key: 10 value: iI");
        heap.add(10, "iI");
        System.out.println("Inserting key: 90 value: jJ");
        heap.add(90, "jJ");
        System.out.println("Inserting key: 53 value: kK");
        heap.add(53, "kK");
 
        System.out.println("\nDisplaying heap:-\n");
        System.out.println(heap.toString());
        System.out.println("\nRemoving key:");
        System.out.println("Value removed should be \"fF\": " + heap.remove());
        System.out.println("Heap after deletion\n");
        System.out.println(heap.toString());

        System.out.println("\nPerforming heapSort....\n");
        heap.heapSort();
        System.out.println("\nAfter sorting:-\n");
        System.out.println(heap.toString());

        System.out.println("\nSorting 7000 names file using heap sort........\n");
        DSAHeap fileHeap = new DSAHeap(7000);
        fileHeap = readFile("HeapFile.csv");
        fileHeap.heapSort();
        writeFile("HeapSort.csv", fileHeap);
        System.out.println("SUCCESSFULLY performed heap sort algorithm and stored in HeapSort.csv"); 
    }

    public static DSAHeap readFile(String inFileName)
    {
        DSAHeap heap = new DSAHeap(7000);
    
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
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
                processLine(line, heap);
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
        return heap;
    } 

    private static void processLine(String csvRow, DSAHeap heap)
    {
        String[] splitLine;
        splitLine = csvRow.split(",");
        heap.add(Integer.parseInt(splitLine[0]), splitLine[1]);
   
    }

    public static void writeFile(String filename, DSAHeap heap)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename);
            pw = new PrintWriter(fileStrm);
              
             pw.print(heap.toString());
                            
             pw.close();
        }
        catch(IOException e)
        {
            if(fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                {}
            }
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    } //End writeFile. 


}
