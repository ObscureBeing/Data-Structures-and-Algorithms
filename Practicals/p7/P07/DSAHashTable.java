import java.util.*;

public class DSAHashTable
{
    private class HashEntry
    {
        private int key;
        private Object value;
        private int state; //0: free, 1:used, 2:previousy used

        public HashEntry(int inKey, Object inValue)
        {
            key = inKey;
            value = inValue;
            state = 0;
        }

        public HashEntry()
        {
            state = 0;
        }

        public int getKey()
        {
            return key;
        }

        public Object getValue()
        {        
            return value;
        }

        public int getState()
        {
            return state;
        }

        public void setKey(int inKey)
        {
            key = inKey;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public void setState(int inState)
        {
            state = inState;
        }    
    }

    private HashEntry[] hashArray = new HashEntry[1543];
    private int count;
    private int probe_limit; 

    public DSAHashTable()
    {
        createEntries();
    }

    public DSAHashTable(int tableSize)
    {
        hashArray = new HashEntry[tableSize];
        createEntries();
    }

    private void createEntries()    
    {
        for(int i = 0; i < hashArray.length; i++)   
        {
            hashArray[i] = new HashEntry();
        }
    }

    public void put(int inKey, Object inValue)
    {
        if(count == hashArray.length/2)
        {
            int newSize = (int)(hashArray.length * 1.75);
            resize(findNextPrime(newSize));
        }

        int u = hash(inKey) % hashArray.length;
        int v = stepHash(inKey) % hashArray.length;
        int index;
        boolean inserted = false;

        for(int i = 0; i < hashArray.length; i++)
        {
            index = (u + i * v) % hashArray.length; 

            if(hashArray[index].getState() != 1 && !inserted)
            {    
                inserted = true;
                hashArray[index].setKey(inKey);
                hashArray[index].setValue(inValue);
                hashArray[index].setState(1);
            }     

       }
            if(!inserted)
            {
                resize(findNextPrime(hashArray.length) * 2);
                put(inKey, inValue);
            }
 
        count++;
    }

    public Object get(int inKey)
    {
        Object value;
        int index = findKey(inKey);
        value = hashArray[index].value;
        return value;
    }

    public boolean hasKey(int key)
    {
        boolean has = true;
        int index = findKey(key);
    
        if(index == -1)
            has = false;

        return has;
    }

    public void remove(int inKey)
    {
        int index = findKey(inKey);
        if(index != -1)
            hashArray[index].setState(2);
        count --;
    } 

    private int findKey(int inKey)
    {
        int u = hash(inKey) % hashArray.length;
        int v = stepHash(inKey) % hashArray.length;
        int index;
        int foundIdx = -1;

        for(int i = 0; i < hashArray.length; i++)
        {
            index = (u + i * v) % hashArray.length; 

           if(hashArray[index].getKey() == inKey)
            {
                foundIdx = index;
            } 
        }   

        return foundIdx;
    
    }   
 
    public void resize(int size)
    {
        HashEntry[] oldArray = hashArray;
        hashArray = new HashEntry[size];
        createEntries();

        for(int i = 0; i < oldArray.length; i++)
        {
            put(oldArray[i].getKey(), oldArray[i].getValue());
            count --;
        }
    }
    
    private int hash(int key)
    {
        int hashIdx = 0;
        String newKey = String.valueOf(key);

        for(int ii = 0; ii < newKey.length(); ii++) 
        {
            hashIdx = (7 * hashIdx) + newKey.charAt(ii);
            hashIdx %= (hashArray.length + ii) * 2; //randomizes the modulus and prevents overflow
        }
        return hashIdx % hashArray.length;
    }    

    private int stepHash(int inKey)
    {
        char ch = String.valueOf(inKey).charAt(0);
        int hashStep = (inKey % (ch * hashArray.length) * 2) + 1;
        return hashStep;
   }

    private int findNextPrime(int startVal)
    {
        int primeVal;

        if(startVal%2 == 0) 
            primeVal = startVal - 1;
        else
            primeVal = startVal;     

        boolean isPrime = false;

        do
        {
            primeVal += 2;
            int ii = 3;
            isPrime = true;
            double rootVal = Math.sqrt(primeVal);

            do
            {
                if(primeVal % ii == 0)
                    isPrime = false;
                else
                    ii += 2;
            }while(ii <= rootVal && (isPrime));
        
        }while(!isPrime);   
    
        return primeVal;    
    }

    public String toString()
    {
        String display = "";
        for (int i = 0; i < hashArray.length; i++)
        {
            if(hashArray[i].getValue() != null && hashArray[i].getState() == 1)
                display += hashArray[i].getKey() + "," + hashArray[i].getValue() + "\n";
        }

        return display;
    }

}
