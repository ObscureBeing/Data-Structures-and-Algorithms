import java.util.*;

public class CountingSort
{
    public static void main(String[] args)
    {
        int array[] = {20, 45, 100, 33, 12, 478, 1092, 3, 18, 30, 65, 25, 5, 1};
        
        countSort(array);

        System.out.println("Sorted array:- \n");

        for(int i = 0 ; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
 
    }

    public static void countSort(int array[])
    {
        int size = array.length;
        int[] output = new int[size + 1];

        int max = array[0];

        for (int i = 1; i < size; i++) 
        {
            if (array[i] > max)
                max = array[i];
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i) 
        {
          count[i] = 0;
        }

        for (int i = 0; i < size; i++) 
        {
            count[array[i]]++;
        }

        for (int i = 1; i <= max; i++) 
        {
            count[i] += count[i - 1];
        }

       for (int i = size - 1; i >= 0; i--) 
        {
        
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) 
        {
            array[i] = output[i];
        }
  }
}
