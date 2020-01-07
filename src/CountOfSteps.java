
public class CountOfSteps {

    // A recursive function used by countWays 
    static int countWaysUtil(int n, int m) 
    { 
        if (n <= 1) 
            return n; 
        int res = 0; 
        for (int i = 1; i<=m && i<=n; i++) 
            res += countWaysUtil(n-i, m); 
        return res; 
    } 
   
    // Returns number of ways to reach s'th stair 
    static int countWays(int s, int m) 
    { 
        return countWaysUtil(s+1, m); 
    } 
    
    //Dynamic Programming 
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int[] res=new int[n+1];
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++)
        {
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }
    
    // Dynamic program
 // A recursive function used by countWays 
    static int countWaysUtilRecursive(int n, int m) 
    { 
        int res[] = new int[n]; 
        res[0] = 1; res[1] = 1; 
        for (int i=2; i<n; i++) 
        { 
           res[i] = 0; 
           for (int j=1; j<=m && j<=i; j++) 
             res[i] += res[i-j]; 
        } 
        return res[n-1]; 
    } 
       
    // Returns number of ways to reach s'th stair 
    static int countWaysRecursive(int s, int m) 
    { 
        return countWaysUtilRecursive(s+1, m); 
    } 
  
    // Driver method  
    public static void main(String[] args) 
    { 
        int s = 4, m = 2; 
        System.out.println("Nuber of ways = " + countWays(s, m)); 
        
        
        int n = 4; 
        System.out.println(findStep(n)); 
    } 
    
    
    
    //if given a number of steps that could be climbed upon.
    
    // Returns count of ways to reach 
    // n-th stair using 1 or 2 or 3 steps. 
    public static int findStep(int n) 
    { 
        if (n == 1 || n == 0)  
            return 1; 
        else if (n == 2)  
            return 2; 
       
        else
            return findStep(n - 3) +  
                   findStep(n - 2) + 
                   findStep(n - 1);     
    } 
      
    
}