import java.util.*;
public class CallStack
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n;
        System.out.println("Enter a number to calculate factorial.");
        n = sc.nextInt();
        int result = factorial(n);
        System.out.println("\nfactorial of " + n + " is: " + result);
                
    }

    public static int factorial(int n)
    {
        DSAStack s = new DSAStack();

        int fact = 1;

        if(n < 0)
            throw new IllegalArgumentException("Import must not be negative");

        else if(n ==0)
        {
            fact = 1;
        }
        else
        {
            fact = n * factorial(n-1);
            s.push(print(n, n-1, fact));
            System.out.println(s.pop());
        }

        System.out.println();


        return fact;
    }

    public static String print(int n, int m, int fact)
    {
        String str = " factorial(" + n +") | factorial(" + m +") \n factorial so far: " + fact;
        return (str);
    }
    
}

