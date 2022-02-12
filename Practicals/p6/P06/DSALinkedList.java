import java.util.*;
import java.io.*;

public class DSALinkedList implements Iterable, Serializable
{
    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }

    public void save(DSALinkedList objToSave, String filename)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try
        {
            fileStrm = new FileOutputStream(filename);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(this);

            objStrm.close();
        }
        catch(Exception e) // we should have given specific exception?
        {
            throw new IllegalArgumentException("Unable to save object to file.");
        }
    }

    public DSALinkedList load(String filename) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSALinkedList inObj = new DSALinkedList();

        try
        {
            fileStrm = new FileInputStream(filename);
            objStrm = new ObjectInputStream(fileStrm);
            inObj = (DSALinkedList) objStrm.readObject();
            objStrm.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Class DSALinkedList not found " + e.getMessage());
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }
        return inObj;
    }
    
    public class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;

        public DSALinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head;
        }

        public boolean hasNext()
        {
            return(iterNext != null);
        }

        public Object next()
        {
            Object value;
            if(iterNext == null)
                value = null;
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Not supported!");
        }
    }

    private class DSAListNode implements Serializable
    {
        private Object m_value;
        private DSAListNode m_next;
        private DSAListNode m_prev;

        public DSAListNode(Object inValue)
        {
            m_value = inValue;
            m_next = null;
            m_prev = null;
        }

        public Object getValue()
        {
            return m_value;
        }

        public void setValue(Object inValue)
        {
            m_value = inValue;
        }

        public DSAListNode getNext()
        {
            return m_next;
        }

        public void setNext(DSAListNode newNext)
        {
            m_next = newNext;
        }

        public DSAListNode getPrev()
        {
            return m_prev;
        }

        public void setPrev(DSAListNode newPrev)
        {
            m_prev = newPrev;
        }

    }

    private DSAListNode head;
    private DSAListNode tail;  

    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    public void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        DSAListNode prevNd;
        
        if(isEmpty())
        {
            tail = newNd;
        }
        else
        {
            head.setPrev(newNd);
        }
            newNd.setNext(head);
            head = newNd;
    }
    

    public void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);

        if(isEmpty())
            head = newNd;
        else
        {
            tail.setNext(newNd);
            newNd.setPrev(tail);
        }
    
        tail = newNd;       
    }

    public boolean isEmpty()
    {
        return (head == null);
    }
    
    public Object peekFirst()
    {
        Object nodeValue;
        
        if(isEmpty())
            throw new IllegalArgumentException("List is empty. Aborting!");
        else
            nodeValue = head.getValue();

        return nodeValue;
    }

    public Object peekLast()
    {
        Object nodeValue;

        if(isEmpty())
            throw new IllegalArgumentException("List is empty. Aborting!");
        else        
            nodeValue = tail.getValue();
       
        return nodeValue;
    }

    public Object removeFirst()
    {
        Object nodeValue;
        DSAListNode tmp = head;

        if(isEmpty())
            throw new IllegalArgumentException("List is empty. Aborting!");
        else if(head.getNext() == null)
        {
            nodeValue = head.getValue();
            tail = null;
        }
        else
        {
            head.getNext().setPrev(null);
            nodeValue = head.getValue();
        }
        head = head.getNext();
        
        return nodeValue;
    }    

    public Object removeLast()
    {
        Object nodeValue;
        DSAListNode tmp = tail;
      
       if(isEmpty())
            throw new IllegalArgumentException("List is empty. Aborting!");
       else if(head.getNext() == null)
        {
            nodeValue = tail.getValue();
            head = null;
        }
        else
        {
            tail.getPrev().setNext(null);
            nodeValue = tail.getValue();
        }

        tail = tail.getPrev();

        return nodeValue;
    }
}
