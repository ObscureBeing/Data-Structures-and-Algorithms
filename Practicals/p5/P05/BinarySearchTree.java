import java.util.*;
import java.io.*;

public class BinarySearchTree implements Serializable           
{
        public void save(BinarySearchTree objToSave, String filename)
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
            catch(Exception e)
            {
                throw new IllegalArgumentException("Unable to save object to file.");
            }
        }

        public BinarySearchTree load(String filename) throws IllegalArgumentException
        {
            FileInputStream fileStrm;
            ObjectInputStream objStrm;
            BinarySearchTree inObj = new BinarySearchTree();

            try
            {
                fileStrm = new FileInputStream(filename);
                objStrm = new ObjectInputStream(fileStrm);
                inObj = (BinarySearchTree) objStrm.readObject();
                objStrm.close();
            }
            catch(ClassNotFoundException e)
            {
                System.out.println("Class BinarySearchTree not found " + e.getMessage());
            }
            catch(Exception e)
            {
                throw new IllegalArgumentException("Unable to load object from file");
            }
            return inObj;
        }
 
    private class TreeNode implements Serializable
    {
        private String m_key;       
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;



        public TreeNode(String inKey, Object inVal)  
        {
            if(inKey == null)
                throw new IllegalArgumentException("");
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }        
        
        public String getKey()
        {
            return m_key;
        }

        public Object getValue()
        {
            return m_value;
        }

        public TreeNode getLeft()
        {   
            return m_leftChild;
        }

        public void setLeft(TreeNode newLeft)
        {
            m_leftChild = newLeft;
        }

        public TreeNode getRight()
        {
            return m_rightChild;
        }

        public void setRight(TreeNode newRight)
        {
            m_rightChild = newRight;
        }
    }

    private TreeNode m_root;
    public int count;

    public BinarySearchTree()
    {
        m_root = null;
    }

    public Object find(String key)
    {
        return findRec(key, m_root);    
    }

    private Object findRec(String key, TreeNode currNode)
    {
        Object value = null;

        if(currNode == null)
            throw new NoSuchElementException("Key " + key + " not found");
        else if(key.equals(currNode.getKey()))
            value = currNode.getValue();
        else if(key.compareTo(currNode.getKey()) < 0)
            value = findRec(key, currNode.getLeft());
        else
            value = findRec(key, currNode.getRight());

        return value;
    }

    public TreeNode insert(String key, Object value)
    {
         count++;
         return insertRec(key, value, m_root);
    }

    private TreeNode insertRec(String key, Object data, TreeNode currNode) 
    {
        TreeNode updateNode = currNode;

        if(currNode == null)
        {
            TreeNode newNode = new TreeNode(key, data);
            updateNode = newNode;

            if(m_root == null)        
                m_root = updateNode;
 
        }
        else if(key.equals(currNode.getKey()))
        {
            throw new IllegalArgumentException("Duplicate keys!");
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insertRec(key, data, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(insertRec(key, data, currNode.getRight()));            
        }   
                 
        return updateNode;
    }

    public TreeNode delete(String key)
    {
        return deleteRec(key, m_root);
    }

    private TreeNode deleteRec(String key, TreeNode currNode)
    {
        TreeNode updateNode = currNode;

        if(currNode == null)
            throw new IllegalArgumentException("");
        else if(key.equals(currNode.getKey()))
            updateNode = deleteNode(key, currNode);
        else if(key.compareTo(currNode.getKey()) < 0)
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        else
            currNode.setRight(deleteRec(key, currNode.getRight()));

        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;

        if(delNode.getLeft() == null && delNode.getRight() == null)
            updateNode = null;
        else if(delNode.getLeft() != null && delNode.getRight() == null)
            updateNode = delNode.getLeft();
        else if(delNode.getLeft() == null && delNode.getRight() != null)
            updateNode = delNode.getRight();
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());

            if(updateNode != delNode.getRight())
                updateNode.setRight(delNode.getRight());

            updateNode.setLeft(delNode.getLeft());
        }

        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currNode)
    {
        TreeNode successor = currNode;

        if(currNode.getLeft() == null)
            successor = currNode;
        else
        {
            if(currNode.getLeft() != null)
                successor = promoteSuccessor(currNode.getLeft());
            if(successor == currNode.getLeft())
                currNode.setLeft(successor.getRight());
        }

        return successor;
    }

    public int height()
    {
        return heightRec(m_root);
    }

    private int heightRec(TreeNode currNode)
    {
        int htSoFar, leftHt, rightHt;

        if(currNode == null)
            htSoFar = -1;
        else
        {
            leftHt = heightRec(currNode.getLeft());
            rightHt = heightRec(currNode.getRight());

            if(leftHt > rightHt)
                htSoFar = leftHt + 1;
            else
                htSoFar = rightHt + 1;
        }

        return htSoFar;
    }

    public String min()
    {
        return minRec(m_root);
    }

    private String minRec(TreeNode currNode)
    {
        String minKey;

        if(currNode.getLeft() != null)
            minKey = minRec(currNode.getLeft());
        else
            minKey = currNode.getKey();

        return minKey;
    }

    public String max()
    {
        return maxRec(m_root);
    }

    private String maxRec(TreeNode currNode)
    {
        String maxKey;

        if(currNode.getRight() != null)
            maxKey = maxRec(currNode.getRight());
        else
            maxKey = currNode.getKey();

        return maxKey;
    }

    public void traverseTreeInorder()
    {
        traverseTreeRecIn(m_root);
    }

    public void traverseTreePreorder()
    {
        traverseTreeRecPre(m_root);
    }

    public void traverseTreePostorder()
    {
       traverseTreeRecPost(m_root);
    }


    private void traverseTreeRecIn(TreeNode currNode)
    {
        if(currNode != null)
        {
            traverseTreeRecIn(currNode.getLeft());
            System.out.print(currNode.getKey() + " ");
            traverseTreeRecIn(currNode.getRight());
        }

    }

     
    private void traverseTreeRecPre(TreeNode currNode)
    {
        if(currNode != null)
        {
            System.out.print(currNode.getKey() + " ");
            traverseTreeRecPre(currNode.getLeft());
            traverseTreeRecPre(currNode.getRight());
        }

    }

    private void traverseTreeRecPost(TreeNode currNode)
    {
        if(currNode != null)
        {
            traverseTreeRecPost(currNode.getLeft());
            traverseTreeRecPost(currNode.getRight());
            System.out.print(currNode.getKey() + " ");

        }

    }

    public int log2(int x)
    {
        return (int) (Math.log(x) / Math.log(2));
    }

    public void balance()
    {
        bal(count);
    }       

    private void bal(int nodes)
    {
        double balance;
        double maxHt = nodes - 1;
        double minHt = log2(nodes);
        double currHt = height();

        if(currHt == minHt)
            balance = 100;
        else if(currHt == maxHt)
            balance = 0;
        else
        {
            balance = 100 - ((currHt - minHt) / maxHt) * 100;
        }

        System.out.println("Max height possible: " + maxHt);
        System.out.println("Min height possible: " + minHt);
        System.out.println("Current height of the tree: " + currHt);
        System.out.println("Balance %age: " + balance);

    }

    public void writeInorder(String filename)
    {
       writeFileIn(filename, m_root);
    }


    private void writeFileIn(String filename, TreeNode currNode)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename, true);
            pw = new PrintWriter(fileStrm);
            if(currNode != null) 
            {

            writeFileIn(filename, currNode.getLeft());
            pw.print(currNode.getKey() + ",");
            pw.close();

            writeFileIn(filename, currNode.getRight());
            }            
        }
        catch(IOException e)
        {
            if (fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                { }
            }
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }
    public void writePreorder(String filename)
    {
       writeFilePre(filename, m_root);
    }


    private void writeFilePre(String filename, TreeNode currNode)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename, true);
            pw = new PrintWriter(fileStrm);
            if(currNode != null) 
            {

            pw.print(currNode.getKey() + ",");
            pw.close();
            writeFilePre(filename, currNode.getLeft());

            writeFilePre(filename, currNode.getRight());
            }            
        }
        catch(IOException e)
        {
            if (fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                { }
            }
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }
    public void writePostorder(String filename)
    {
       writeFilePost(filename, m_root);
    }


    private void writeFilePost(String filename, TreeNode currNode)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(filename, true);
            pw = new PrintWriter(fileStrm);
            if(currNode != null) 
            {

            writeFilePost(filename, currNode.getLeft());
            pw.print(currNode.getKey() + ",");

            writeFilePost(filename, currNode.getRight());
            pw.close();

            }            
        }
        catch(IOException e)
        {
            if (fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                { }
            }
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }



}
