import java.util.HashMap;

public class FirstNonRepeatingChar {
 public static void main(String[] args) {
	
}
}


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}


class GFG  
{ 
    static final int NO_OF_CHARS = 256; 
    static char count[] = new char[NO_OF_CHARS]; 
      
    /* calculate count of characters  
       in the passed string */
     static void getCharCountArray(String str)  
     { 
         for (int i = 0; i < str.length();  i++) 
              count[str.charAt(i)]++; 
     } 
       
    /* The method returns index of first non-repeating 
       character in a string. If all characters are repeating  
       then returns -1 */
    static int firstNonRepeating(String str) 
    { 
        getCharCountArray(str); 
        int index = -1, i; 
       
        for (i = 0; i < str.length();  i++) 
        { 
            if (count[str.charAt(i)] == 1) 
            { 
                index = i; 
                break; 
            }    
        }   
        
      return index; 
    } 
  
    // Driver method 
    public static void main (String[] args) 
    { 
        String str = "geeksforgeeks"; 
        int index =  firstNonRepeating(str); 
          
        System.out.println(index == -1 ? "Either all characters are repeating or string " + 
                   "is empty" : "First non-repeating character is " +  str.charAt(index)); 
    } 
}