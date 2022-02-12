import java.util.*;
import java.io.*;

public class DSAHashTableTestHarness
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String filename;
        DSAHashTable test = new DSAHashTable();

        System.out.println("Testing to create a table with less values first:-");

        System.out.println("Adding key: 10 value: abc");
        test.put(10, "abc");
        System.out.println("Adding key: 20 value: def");
        test.put(20, "def");
        System.out.println("Adding key: 30 value: ghi");
        test.put(30, "ghi");
        System.out.println("Adding key: 40 value: jkl");
        test.put(40, "jkl");
        System.out.println("Adding key: 50 value: mno");
        test.put(50, "mno");
        System.out.println("Adding key: 60 value: pqr");
        test.put(60, "pqr");
        System.out.println("Adding key: 70 value: stu");
        test.put(70, "stu");
        System.out.println("Adding key: 80 value: vwx");
        test.put(80, "vwx");
        System.out.println("Adding key: 90 value: yza");
        test.put(90, "yza");
        System.out.println("Adding key: 100 value: bcd");
        test.put(100, "bcd");
        System.out.println("\nDisplaying toString():- \n " + test.toString());
        System.out.println("");        

        System.out.println("Removing key 50");
        test.remove(50);
        System.out.println("\nDisplaying toString():- \n " + test.toString());
        System.out.println("");        

        System.out.println("Get key 20: value: def");
        System.out.println(test.get(20));

        System.out.println("\nDoes key: 30 exist?");
        boolean has = test.hasKey(30);
        if(has == true)
            System.out.println("Key 30 exists");
        else
            System.out.println("Key 30 does not exist");

        System.out.println("\nDoes key: 120 exist?");
        boolean key = test.hasKey(120);
        if(key == true)
            System.out.println("Key 120 exists");
        else
            System.out.println("Key 120 does not exist");

        System.out.println("\nCreating hash table by reading a csv file and save it as HashTable.csv\n");
        System.out.println("Please enter the file name:");
        filename = sc.nextLine();
               
        DSAHashTable table = new DSAHashTable();
        table = readFile(filename);
        writeFile("SavedHashTable.csv", table);
        System.out.println("SUCCESSFULLY saved hashtable in SavedHashTable.csv. :))");
   }

    public static DSAHashTable readFile(String inFileName)
    {
        DSAHashTable table = new DSAHashTable();
    
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
                processLine(line, table);
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
        return table;
    } 

    private static void processLine(String csvRow, DSAHashTable table)
    {
        String[] splitLine;
        splitLine = csvRow.split(",");
        System.out.println("key: " + splitLine[0] + " value: " + splitLine[1]);
        table.put(Integer.parseInt(splitLine[0]), splitLine[1]);
   
    }

    public static void writeFile(String filename, DSAHashTable table)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename);
            pw = new PrintWriter(fileStrm);
              
             pw.print(table.toString());                
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
