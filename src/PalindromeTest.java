import java.util.Scanner;

/**
 * Java program to show you how to check if a String is palindrome or not.
 * An String is said to be palindrome if it is equal to itself after reversing.
 * In this program, you will learn how to check if a string is a palindrome in java using recursion
 * and for loop both. 
 *
 * @author Javin
 */
public class PalindromeTest {

   
    public static void main(String args[]) {
        System.out.println("Is aaa palindrom?: " + isPalindromString("aaa"));
        System.out.println("Is abc palindrom?: " + isPalindromString("abc"));
       
        System.out.println("Is bbbb palindrom?: " + isPalindromString("bbbb"));
        System.out.println("Is defg palindrom?: " + isPalindromString("defg"));
     
       
    }

    /**
     * Java method to check if given String is Palindrome
     * @param text
     * @return true if text is palindrome, otherwise false
     */
    public static boolean isPalindromString(String text){
       String reverse = reverse(text);
       if(text.equals(reverse)){
           return true;
       }
     
       return false;
    }
   
    /**
     * Java method to reverse String using recursion
     * @param input
     * @return reversed String of input
     */
    public static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
       
        return input.charAt(input.length()- 1) + reverse(input.substring(0, input.length() - 1));
    }
   
}

class Palindrome{

    public static void main(String args[]) {
       
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a String");
        String input = reader.nextLine();
        
        System.out.printf("Is %s a palindrome? : %b %n", input, isPalindrome(input));
        
        
        System.out.println("Please enter another String");
        input = reader.nextLine();
        
        System.out.printf("Is %s a palindrome? : %b %n", input, isPalindrome(input));
        
        reader.close();
        

    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(array[i]);
        }

        String reverseOfString = sb.toString();

        return input.equals(reverseOfString);
    }

}

class PalindromeNumber{
public static void main(String args[]){
System.out.print("Enter Number: ");
Scanner read = new Scanner(System.in);
int num = read.nextInt();
int n = num;
//reversing number
int rev=0,rmd;
while(num > 0)
{
rmd = num % 10;
rev = rev * 10 + rmd;
num = num / 10;
}
if(rev == n)
System.out.println(n+" is a Palindrome Number!");
else
System.out.println(n+" is not a Palindrome Number!");
}
}