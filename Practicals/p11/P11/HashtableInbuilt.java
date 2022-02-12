import java.util.*;

public class HashtableInbuilt
{
    public static void main(String[] args) 
    {   
        Hashtable<Integer, String> hash_table = new Hashtable<Integer, String>(); 
  
        hash_table.put(10, "Hi"); 
        hash_table.put(15, "there"); 
        hash_table.put(20, "good"); 
        hash_table.put(25, "day"); 
        hash_table.put(30, "to You"); 
  
        System.out.println("Initial Table is: " + hash_table); 
  
        System.out.println("Is the value 'good' present? " + hash_table.contains("good")); 
  
        System.out.println("Is the value 'bad' present? " + hash_table.contains("bad")); 
    } 
}
