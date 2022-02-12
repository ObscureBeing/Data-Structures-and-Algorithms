import java.util.*;

public class ShellSort
{
    public static void main(String[] args)
    {
        int array[] = {20, 45, 12, 478, 1092, 3, 18, 30, 65, 25, -5};
        
        sort(array);

        System.out.println("Sorted array:- \n");

        for(int i = 0 ; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
    
    public static void sort(int arr[])
    {
        int n = arr.length; 
  
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
           for (int i = gap; i < n; i += 1) 
            { 
               int temp = arr[i]; 
  
               int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
               arr[j] = temp; 
            }
        } 
        
    }
}

