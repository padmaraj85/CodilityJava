import java.io.*; 
import java.util.*; 
import java.lang.*; 
  
public class MaxAverageMarks { 
  
    // Function to find the 
    // list of students having maximum average score 
    // Driver code 
    static void getStudentsList(String[] file) 
    { 
        // Variables to store average score of a student 
        // and maximum average score 
        int avgScore; 
        int maxAvgScore = Integer.MIN_VALUE; 
  
        // List to store names of students 
        // having maximum average score 
        ArrayList<String> names = new ArrayList<>(); 
  
        // Traversing the file data 
        for (int i = 0; i < file.length; i += 4) { 
  
            // finding average score of a student 
            avgScore = (Integer.parseInt(file[i + 1]) +  
                        Integer.parseInt(file[i + 2]) +  
                       Integer.parseInt(file[i + 3])) / 3; 
  
            if (avgScore > maxAvgScore) { 
                maxAvgScore = avgScore; 
  
                // Clear the list and add name of student 
                // having current maximum average score in the list 
                names.clear(); 
                names.add(file[i]); 
            } 
  
            else if (avgScore == maxAvgScore) 
                names.add(file[i]); 
        } 
  
        // Printing the maximum average score and names 
        // of students having this maximum average score 
        // as per the order in the file. 
        for (int i = 0; i < names.size(); i++) { 
            System.out.print(names.get(i) + " "); 
        } 
  
        System.out.print(maxAvgScore); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        String[] file = { "Shrikanth", "20", "30",  
                        "10", "Ram", "100", "50", "10" }; 
        getStudentsList(file); 
    } 
} 