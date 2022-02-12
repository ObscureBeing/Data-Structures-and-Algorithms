import java.util.*;

public class DSAHeap
{
    private class DSAHeapEntry
    {
        private int priority;
        private Object value;

        public DSAHeapEntry()
        {
        }

        public DSAHeapEntry(int inPriority, Object inValue)
        {
            priority = inPriority;
            value = inValue;
        }

        public int getPriority()
        {
            return priority;
        }
        
        public void setPriority(int inPriority)
        {
            priority = inPriority;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }        
    }

    private DSAHeapEntry[] heap;
    private int count;

    public DSAHeap(int maxSize)
    {
        heap = new DSAHeapEntry[maxSize];
    }

    public void add(int priority, Object value)
    {
        DSAHeapEntry entry = new DSAHeapEntry(priority, value);
        if(count == heap.length)
            System.out.println("Heap is full, can not add more.");

        heap[count] = entry;
        trickleUp(heap, count++);
    }

    public Object remove()
    {
        if(count == 0)
            throw new IllegalArgumentException("Array is empty, cannot remove.");

        DSAHeapEntry temp = heap[0];
        heap[0] = heap[--count];
        trickleDown(heap, 0, count);
        return temp.getValue();
    }
        
    
    public DSAHeapEntry[] heapify(DSAHeapEntry[] heapArray, int numItems)
    {
        for(int ii = (numItems/2) - 1; ii >= 0; ii --)
        {
            trickleDown(heapArray, ii, numItems);
        }

        return heapArray;
    }
    public void heapSort()
    {
        heapify(heap, count);

        for(int ii = count - 1; ii > 0; ii--)
        {
            DSAHeapEntry temp = heap[0];
            heap[0] = heap[ii];
            heap[ii] = temp;
            trickleDown(heap, 0, ii);
        }

        
    }

    private DSAHeapEntry[] trickleUp(DSAHeapEntry[] heapArray, int currIdx)
    {
        DSAHeapEntry temp;
        int parentIdx = (currIdx-1) / 2;

        if(currIdx > 0)
        {
            if(heapArray[currIdx].getPriority() > heapArray[parentIdx].getPriority())
            {
                temp = heapArray[parentIdx];
                heapArray[parentIdx] = heapArray[currIdx];
                heapArray[currIdx] = temp;
                trickleUp(heapArray, parentIdx);
            }
        }

        return heapArray;
        
    }

    private DSAHeapEntry[] trickleDown(DSAHeapEntry[] heapArray,int currIdx, int numItems)
    {
        int lChildIdx = currIdx * 2 + 1;
        int rChildIdx = lChildIdx + 1;
        int largeIdx = currIdx; //set to currIdx for recusive usage, otherwise keeps pointing at root
        //check if left child is valid
        if(lChildIdx < numItems) 
        {
            //check if left child is greater than current
            if(heapArray[lChildIdx].getPriority() > heapArray[largeIdx].getPriority()) 
            {
            //if it is, then set left child as largeIdx
                largeIdx = lChildIdx;
            }
            //left child may be largeIdx
            //check if right child is valid
            if(rChildIdx < numItems) 
            {
                //check if right child is greater than largeIdx
                if(heapArray[rChildIdx].getPriority() > heapArray[largeIdx].getPriority()) 
                {
                    //if it is, then set right child as largeIdx
                    largeIdx = rChildIdx;
                }
            }
        }
        //if largeIdx == currIdx, if it can go no lower swapping higher values
        //return <- since it's just a return, set the if to != and execute the else statement instead
        //else, trickleDown(heapArray, largeIdx, numItems)
        if(largeIdx != currIdx) 
        {
            //swap values in largestIdx with currIdx
            DSAHeapEntry temp = heapArray[currIdx];
            heapArray[currIdx] = heapArray[largeIdx];
            heapArray[largeIdx] = temp;
            trickleDown(heapArray, largeIdx, numItems);
        }
        return heapArray;
    }

    public String toString()
    {
        String display = "";

        for(int i = 0; i < count; i++)
        {
             display += heap[i].getPriority() + "," + heap[i].getValue() + "\n";
        }

        return display;
    }
}
