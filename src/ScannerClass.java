import java.util.Scanner;

public class ScannerClass {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int[] scores = new int[n];
	    int c = 0;

	    for(int i = 0; i < scores.length; i++){
	        scores[i] = scan.nextInt();
	    }

	    for(int j = scores.length-1; j >= 0; j--){
	        if(j > 0) {
	            boolean b = scores[j] <= scores[j-1] ? true : false;
	            if(b == false){
	             c++;
	            }
	         }
	     }
	    if(c > 0){
	        System.out.print(false);
	    }
}
}
