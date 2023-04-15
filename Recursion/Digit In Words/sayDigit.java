import java.util.*;

public class Main
{
    static void sayDigit(int n, String[] arr){
        
        //base case
        
        if(n == 0){
            return; 
        }
        
        //processing
        
        int digit = n%10;
        n = n/10;
        
        // recursive call 
        
	    sayDigit(n, arr);
        System.out.print(arr[digit] + " ");
	  
    }
    
	public static void main(String[] args) {
	    
	    String[] arr = {"zero", "one", " two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
	    
	    Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
	    sayDigit(n, arr);

	}
}
