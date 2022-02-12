import java.util.*;

public class RadixLSDSort
{
    public static void main(String[] args)
    {
        int array[] = {20, 45, 59, 100, 33, 12, 478, 1092, 3, 18, 30, 65, 25, 5, 1};
        
        radixsort(array);

        System.out.println("Sorted array:- \n");

        for(int i = 0 ; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
 
    }

    public static void radixsort(int arr[]) 
    { 
        int n = arr.length;
        int m = getMax(arr, n); 
  
       for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 

    public static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 

    public static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 
  
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
  
       for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
 
      for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
  
}
