/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static boolean linearSearch(int[] arr, int left, int right, int key){
        
        // base case 
        
        if(right < left){
            return false;
        }
        
        if(arr[left] == key){
            return true;
        } else {
            return remainingPart;
        }
        
        
    }
    
	public static void main(String[] args) {
		
		int[] arr = {2, 4, 1, 8, 0};
		
		int size = 5;
		int key = 2;
		
		boolean ans = linearSearch(arr, size, key);
		
		if(ans){
		    System.out.println("ELEMENT PRESENT");
		} else {
		    System.out.println("ELEMENT NOT PRESENT");
		}
	}
}


// to be corrected
