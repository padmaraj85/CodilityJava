/* Problem Name is &&& HashMap &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement MyHashMap correctly.
 * 4) If time permits, some possible follow-ups.
 */

import java.util.*;

public class CustomHashMap
{
  /**
   * class MyHashMap
   *
   * Associates a key-value pair in memory such that lookups
   * and inserts can be performed in O(1) time for a reasonably
   * small set of data, and scales linearly (at worst) for larger
   * sets of key-value pairs.
   *
   * Each unique key is associated with one single value.
   */
  private class MyHashMap<K, V>
  {
    MyHashMap() {}
    
    private LinkedList<KeyValue<K,V>>[] bucket =  new LinkedList[10];
   // private List<String> list = new ArrayList<String>();
   
    
    

    void put(K key, V value)
    {
      
      
      // todo: implement
      int hashCode = (Integer)key.hashCode();
      int bucketHashCode = hashCode%10;
      //System.out.println(hashCode);
      //System.out.println(bucketHashCode);
      
      if(bucket[bucketHashCode]==null){
        LinkedList<KeyValue<K,V>> list = new LinkedList<KeyValue<K,V>>();
        //EntrySet entrySet = new EntrySet();
        //EntrySet.
        list.push(new KeyValue(key,value));
        bucket[bucketHashCode]=list;
      }else{
        LinkedList<KeyValue<K,V>> list = bucket[bucketHashCode];
        list.push(new KeyValue(key,value));
      }
      
      
     
      
    }

    V get(K key)
    {
      // todo: implement
      int hashCode = (Integer)key.hashCode();
      int bucketHashCode = hashCode%10;
      //System.out.println(hashCode);
     //ystem.out.println(bucketHashCode);
      
      
      
      if(bucket[bucketHashCode]==null){
        return null;
      }else{
        LinkedList<KeyValue<K,V>> list = bucket[bucketHashCode];
        if(list.size()>1){
          for(KeyValue<K,V> keyValue: list){
           // String[] arrKeyValue = keyValue.split(",");
            if((keyValue.getKey()).equals(key)){
              return keyValue.getValue();
            }
          }
          
        }else{
          KeyValue<K,V> keyValue = list.peek();        
          //System.out.println(keyValue);
          return keyValue.getValue();
        }
      }
      return null;
      
    }
  }

  /**
   * bool doTestsPass()
   * Runs various tests. Returns true if tests pass. Otherwise,
   * returns false.
   */
  public void doTestsPass()
  {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    int[][] testCases = {{1, 2}, {3, 4}, {5, 6},{11,11}};
    boolean passed = true;

    MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();

    for (int[] test : testCases)
    {
      Integer key = test[0];
      Integer value = test[1];

      map.put(key, value);

      if (!value.equals(map.get(key)))
      {
        System.out.println("Test failed [" + key + "," + value + "]");
        passed = false;
      }
    }

    if (passed)
    {
      System.out.println("All tested passed");
    }

  }

  
  class KeyValue<K,V>{
    private K key;
    private V value;
    
    public KeyValue(K key,V value ){
      this.key = key;
      this.value = value;
        
    }
    
    public K getKey(){
      return this.key;
    }
    
    
    public V getValue(){
      return this.value;
    }
    
    public String toString(){
      return ""+key  +","+ value;
    }
  }
  /**
   * Execution entry point.
   */
  public static void main(String args[])
  {
    new CustomHashMap().doTestsPass();
    new CustomHashMap().debug();
  }
  
  
  public void debug()
  {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    String[][] testCases = {{"1", "2"}, {"3", "4"}};
    boolean passed = true;

    MyHashMap<String, String> map = new MyHashMap<String, String>();

    for (String[] test : testCases)
    {
      String key = test[0];
      String value = test[1];

      map.put(key, value);

      if (!value.equals(map.get(key)))
      {
        System.out.println("Test failed [" + key + "," + value + "]");
        passed = false;
      }
    }

    if (passed)
    {
      System.out.println("All tested passed");
    }

  }
}