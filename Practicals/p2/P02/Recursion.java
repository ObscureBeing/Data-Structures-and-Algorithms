/*************************************************************
 * Name: Recursion.java
 * Author: Muskan vig
 * Date created: 18/08/2020
 * Purpose: A menu driven code with different functionality.
 * Prac number: 2
 ***************************************************************/

import java.util.*;
import java.io.*;
public class Recursion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
        int choice;       
        do
        {
            System.out.println("Choose one of the following activiites: ");
            System.out.print("\n1. Factorial \n2. Fibonacci  ");
            System.out.print("\n3. Greatest Common Denominator \n4. Number Conversion ");
            System.out.println("\n5. Towers of Hanoi \n0. Exit");

            choice = sc.nextInt();
        
            switch(choice)
            {
                case 1: int  n, result;            
                        System.out.print("Please enter the number: ");
                        n = sc.nextInt(); 
                        result = factorial(n);
                        System.out.println("Result = " + result);  
                        break;

                case 2: int num, fibVal;                 
                        System.out.print("Please enter the number: ");
                        num = sc.nextInt();
                        fibVal = fibonacci(num);
                        System.out.println("Result = " + fibVal);
                        break;

                case 3: int n1, n2, gcd;
                        System.out.println("Enter first number: ");
                        n1 = sc.nextInt();
                        System.out.println("Enter second number: ");
                        n2 = sc.nextInt();
                        gcd = gcd(n1, n2);
                        System.out.println("GCD of given two numbers is : " + gcd);
                        break;  

                case 4: int decNum, base;
                        String baseNum;
                        System.out.println("Enter the number: ");
                        decNum = sc.nextInt();
                        System.out.println("Enter the base you wish to convert to: ");
                        base = sc.nextInt();
                        baseNum = numberConvert(decNum, base);
                        System.out.println(decNum + " in base " + base + " is " + baseNum);
                        break;

                case 5: int disks, source, destination, indent = 0;
        
                        System.out.println("Enter the disk number: ");
                        disks = sc.nextInt();
                        System.out.print("Please enter the source peg: ");
                        source = sc.nextInt();
                        System.out.println("Please eneter the destination peg: ");
                        destination = sc.nextInt();

                        TowersOfHanoi(disks, source, destination, indent);
                        break;

                case 0: break;
    
                default: System.out.println("Invalid choice.");

            }
        
        }while(choice !=0);

        }
        catch(InputMismatchException e)
        {
            System.out.println("Please Check your input." + e.getMessage());
        }   
    }

    public static int factorial(int n)
    {
        int fact = 1;

        if(n < 0)
            throw new IllegalArgumentException("Import must not be negative");

        else if(n ==0)
            fact = 1;

        else
            fact = n * factorial(n-1);

        return fact;
    }

    public static int fibonacci(int n)
    {
        if(n < 0)
            throw new IllegalArgumentException("n can't be negative.");
        int fibVal = 0;            

        if(n == 0)
            fibVal = 0;
    
        else if(n == 1)
            fibVal = 1;

        else
            fibVal = fibonacci(n-1) + fibonacci(n-2);
        return fibVal;
            
    }

    public static int gcd(int num1, int num2)
    {
            int value;

            if(num2 != 0)
            {
                value = gcd(num2, num1 % num2);
            }
            else
            {
                value = num1;
            }
            return value;            
    }

    public static String numberConvert(int n, int b)
    {
        int alpha;
        String alphaNum = " ";

        if(b > 16)
            throw new IllegalArgumentException("Base can be upto 16.");
        
        String s;

        if(n==0)
            s = " ";
        else if(n%b > 9)
        {   alpha = (n%b);

            switch(alpha)
            {
                case 10: alphaNum = "A";
                         break;
                case 11: alphaNum = "B";
                         break;
                case 12: alphaNum = "C";
                         break;
                case 13: alphaNum = "D";
                         break;
                case 14: alphaNum = "E";
                         break;
                case 15: alphaNum = "F";
                         break;
            }
 
            s = numberConvert(n/b, b) + alphaNum;
        }
        else
        {
            s = numberConvert(n/b, b) + (n%b);          
        }
        return s;
    }

    public static void TowersOfHanoi(int n, int src, int dest, int indent)
    {
        int tmp = 6 - src - dest;
       
        String ind;
        ind = indentation(indent);
        
        if(n == 1)
        { 
//            moveDisk(n, src, dest);

            System.out.println(ind + "\t" + "Enter (" + n + " disk): " + "s=" + src + ", i=" + tmp + ", d=" + dest);
            System.out.println(ind + "\t\t" + "Base case: move disk " + n + " from " + src + " to "+ dest);
            System.out.println(ind + "\t" + "Return (" + n + " disk)"); 
        }
        else
        {
            tmp = 6 - src - dest;

            System.out.println(ind + "\t" + "Enter (" + n + " disks): " + "s=" + src + ", i=" + tmp + ", d=" + dest);

            TowersOfHanoi(n-1, src, tmp, indent + 1);
//            moveDisk(n, src, dest);

            System.out.println(ind +"\t" + "Move bottom disk " + n + " from " + src + " to "+ dest);

            TowersOfHanoi(n-1, tmp, dest, indent + 1);
    
            System.out.println(ind +"\t" + "Return (" + n + " disks)");
        }
        
    }

    public static String indentation(int counter)
    {   
        String str = "\t";

        for(int i = 0; i < counter; i++)
        {
            str = str + "\t";
        }
        return str;   
    }

 /*   public static void moveDisk(int n, int src, int dest)
    {
        System.out.println("Moving " + n + " disk from peg: " + src + " to peg: " + dest );
    } */
}

