/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
        int pass = 0;
        boolean sorted;

        do
        {
            sorted = true;

            for(int ii = 0; ii < A.length- 1 - pass ; ii++)
            {
                if(A[ii] > A[ii+1])
                {
                    int temp = A[ii];
                    A[ii] = A[ii+1];
                    A[ii+1] = temp;

                    sorted = false;
                }
            }
            pass ++;

        }while(!sorted);
    }//bubbleSort()



    /*************************************************
    * SUBMODULE:
    * IMPORT:
    * EXPORT:
    * PURPOSE:
    ******************************************************/

    // selection sort
    public static void selectionSort(int[] A)
    {
        int minIdx, temp;
        
        for(int ii = 0; ii < A.length-1; ii++)
        {
            minIdx = ii;
            for(int jj = ii+1; jj < A.length; jj++)
            {
                if(A[jj] < A[minIdx])
                {
                    minIdx = jj;
                }
            }

        temp = A[minIdx];
        A[minIdx] = A[ii];
        A[ii] = temp;
        }    
/*        for(int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + " ");
        }  */



    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int ii, temp;

        for(int nn = 1; nn <= A.length-1; nn++)
        {
            ii = nn;

            while((ii > 0) && (A[ii-1] > A[ii]))
            {
                temp = A[ii];
                A[ii] = A[ii-1];
                A[ii-1] = temp;

                ii = ii - 1; 
            }
        }
        
    
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static int[] mergeSort(int[] array)
    {
        return mergeSortRecurse(array, 0, array.length-1);
 
    }//mergeSort()
    private static int[] mergeSortRecurse(int[] array, int leftIdx, int rightIdx)
    {
        int midIdx;

        if(leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx) / 2;
    
            mergeSortRecurse(array, leftIdx, midIdx);
            mergeSortRecurse(array, midIdx+1, rightIdx);

            merge(array, leftIdx, midIdx, rightIdx);
        }
        else
        {

        }
        return array;
 
    }//mergeSortRecurse()

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

    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
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
            //leftmost pivot selection
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


}//end Sorts calss
