import java.util.*;

public class QuickSortMedian
{
    public static void main(String[] args)
    {
        int[] arr = {7, 3, 6, 2, 5, 56, 78, 980};
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
            //Median of 3 pivot selection
            pivotIdx = medianOf3(array, leftIdx, rightIdx);
            newPivotIdx = doPartitioning(array, leftIdx, rightIdx, pivotIdx);

            quickSortRecurse(array, leftIdx, newPivotIdx-1);
            quickSortRecurse(array, newPivotIdx+1, rightIdx);
        }

        return array;

    }//quickSortRecurse()

    private static int medianOf3(int[] array, int left, int right)
    {
        int center = (left+right)/2;

        if(array[left] > array[center])
            swap(array, left, center);
        if(array[left] > array[right])
            swap(array, left, right);
        if(array[center] > array[right])
            swap(array, center, right);

        swap(array, center, right-1);
        
        return array[right-1];
    }
    
    private static void swap(int[] array, int dex1, int dex2)
    {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    } 

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
