import java.util.*;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = {7, 3, 6, 2, 5};
        sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + " ");
        }
        
    }

    public static int[] sort(int[] array)
    {
        return mergeSort(array, 0, array.length-1);
    }
    
    public static int[] mergeSort(int[] array, int leftIdx, int rightIdx)
    {
        int midIdx;

        if(leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx) / 2;
    
            mergeSort(array, leftIdx, midIdx);
            mergeSort(array, midIdx+1, rightIdx);

            merge(array, leftIdx, midIdx, rightIdx);
        }
        else
        {

        }
        return array;
    }

    public static int[] merge(int[] array, int leftIdx, int midIdx, int rightIdx)
    {
        int tempArr[] = new int[rightIdx-leftIdx+1];
        int ii = leftIdx;
        int jj = midIdx + 1;
        int kk = 0;

        while((ii <= midIdx) && (jj <= rightIdx))
        {
            if(array[ii] <= array[jj])
            {
                tempArr[kk] = array[ii];
                ii = ii + 1;
            }
            else
            {
                tempArr[kk] = array[jj];
                jj = jj + 1;
            }

            kk = kk + 1;
        }        

        for(ii = ii; ii <= midIdx; ii++)
        {
            tempArr[kk] = array[ii];
            kk = kk + 1;
        }

        for(jj = jj; jj <= rightIdx; jj++)
        {
            tempArr[kk] = array[jj];
            kk = kk + 1;
        }

        for(kk = leftIdx; kk <= rightIdx; kk++)
        {
            array[kk] = tempArr[kk-leftIdx];
        }

        return array;
    }
}
