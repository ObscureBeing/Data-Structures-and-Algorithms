import java.util.*;

public class QuickSortLeft
{
    public static void main(String[] args)
    {
        int[] arr = {7, 3, 6, 2, 5, 567, 1000, 783, 564, 121, 1};
        quickSort(arr);
 
       for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + " ");
        }
 
    }

    public static void quickSort(int[] array)
    {
         quickSortRecurse(array, 0, array.length-1);

    }//quickSort()

    private static int[] quickSortRecurse(int[] array, int leftIdx, int rightIdx)
    {
        int pivotIdx;
        int newPivotIdx;

        if(rightIdx > leftIdx)
        {
            //Leftmost pivot selection        
            pivotIdx = leftIdx;
            newPivotIdx = doPartitioning(array, leftIdx, rightIdx, pivotIdx);

            quickSortRecurse(array, leftIdx, newPivotIdx-1);
            quickSortRecurse(array, newPivotIdx+1, rightIdx);
        }

        return array;

    }//quickSortRecurse()

    private static int doPartitioning(int[] array, int leftIdx, int rightIdx, int pivIdx)
    {
        int pivotVal = array[pivIdx];
        array[pivIdx] = array[rightIdx];
        array[rightIdx] = pivotVal;
        int temp;

        int currIdx = leftIdx;

        for(int ii = leftIdx; ii <= rightIdx-1; ii++)
        {
            if(array[ii] < pivotVal)
            {
                temp = array[ii];
                array[ii] = array[currIdx];
                array[currIdx] = temp;
                currIdx = currIdx+1;
            }
        }

        int newPivIdx = currIdx;
        array[rightIdx] = array[newPivIdx];
        array[newPivIdx] = pivotVal;

		return newPivIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


    
}
