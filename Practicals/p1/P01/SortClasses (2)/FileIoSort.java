/* This code is taken from prac-9 senmester 1 2020 PDI */

import java.util.*;
import java.io.*;
public class FileIoSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String fileName = "RandomNames7000.csv";
        String writeFile1, writeFile2, writeFile3;
        String item;
        Student[] myStudents = new Student[7000];         
        Student[] sortedStudents = new Student[7000];          
        
        
        myStudents = readFile(fileName);
        
        
        sortedStudents = bubbleSort(myStudents, sc);
        
        System.out.println("Enter the file name you wish to write bubbble sort on: ");
        writeFile1 = sc.nextLine();
        writeFile(writeFile1, sortedStudents);
        System.out.println("Wriiten! " + writeFile1 + " :)"); 
    
        sortedStudents = selectionSort(myStudents, sc);
    
        System.out.println("Enter the file name you wish to write selection sort on: ");
        writeFile2 = sc.nextLine();
        writeFile(writeFile2, sortedStudents);
        System.out.println("Wriiten! " + writeFile2 + " :)");

        sortedStudents = insertionSort(myStudents, sc);
        
        System.out.println("Enter the file name you wish to write insertion sort on: ");
        writeFile3 = sc.nextLine();
        writeFile(writeFile3, sortedStudents);
        System.out.println("Wriiten! " + writeFile3 + " :)");
 
     
    } //End main.

    //readFile
    
    public static Student[] readFile(String inFileName)
    {
    
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        Student[] myStudents = new Student[7000];
        try
        {
            fileStream = new FileInputStream(inFileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;
            line = bufRdr.readLine();
    
            while(line != null && lineNum < myStudents.length)
            {
                
                String myLine[] = line.split(",");
        
                myStudents[lineNum] =  convertLineToStudent(myLine);
                line = bufRdr.readLine();
                lineNum++;

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
        return myStudents;
    } //End readFile

    //convertLineToStudent
  
    public static Student convertLineToStudent(String[] splitLine)
    { 
            Student newStu = new Student();
            newStu.setStudentID(Integer.parseInt(splitLine[0]));
            newStu.setName(splitLine[1]);
            
            return newStu;
    } //End convertLineToStudent

    //bubbleSort

    public static Student[] bubbleSort(Student[] arrayUnsorted, Scanner sc)
    {
        int pass = 0;
        boolean sorted;        
    
        do
        {
            sorted = true;
            for(int ii = 0; ii < arrayUnsorted.length-1-pass; ii++)
            {
                if(arrayUnsorted[ii].getStudentID() > arrayUnsorted[ii+1].getStudentID())
                {
                    Student temp = arrayUnsorted[ii];
                    arrayUnsorted[ii] = arrayUnsorted[ii+1];
                    arrayUnsorted[ii+1] = temp;
                    sorted = false;
                }
            }
            pass++;

        }while(!sorted);
   
        return arrayUnsorted;
    } //End bubbleSort

    //selectionSort

    public static Student[] selectionSort(Student[] arrayUnsorted, Scanner sc)
    {
        
        Student temp;
        
        for(int nn = 0; nn < arrayUnsorted.length-1; nn++)
        {
            int minIdx = nn;

            for(int jj = nn+1; jj < arrayUnsorted.length; jj++)
            {
                if(arrayUnsorted[jj].getStudentID() < arrayUnsorted[minIdx].getStudentID())
                {
                    minIdx = jj;
                }
            }
            temp = arrayUnsorted[minIdx];
            arrayUnsorted[minIdx] = arrayUnsorted[nn];
            arrayUnsorted[nn] = temp;
        }
           return arrayUnsorted;
    } //End selectionSort

    //insertionSort

    public static Student[] insertionSort(Student[] arrayUnsorted, Scanner sc)
    {
        int ii;
        Student temp;
        
        for(int nm = 1; nm <= arrayUnsorted.length-1; nm++)
        {
            ii = nm;
            temp = arrayUnsorted[ii]; 
            while((ii > 0) && (arrayUnsorted[ii-1].getStudentID() > temp.getStudentID()))
            {
                arrayUnsorted[ii] = arrayUnsorted[ii-1];
                ii = ii-1;
            }
            arrayUnsorted[ii] = temp;
        }
        return arrayUnsorted;
    } //End insertionSort

    /**************************************************
    * Name: writeFile                           
    * Import: filename(String), writeArray(int[])    
    * Export: none                                     
    * Purpose: will write array on csv file.      
    ****************************************************/

    public static void writeFile(String filename, Student[] writeArray)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename);
            pw = new PrintWriter(fileStrm);
            for(int ii = 0; ii < writeArray.length; ii++)
            {
               
                pw.print(writeArray[ii] + ",");   //will write array on csv file element by element.
                
                pw.print("\n");
            }
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


} //End FileIoSort

