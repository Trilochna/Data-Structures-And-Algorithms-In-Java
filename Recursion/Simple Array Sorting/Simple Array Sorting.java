import java.util.*;

public class Main
{
    static boolean isSorted(int[] arr, int size){
        
        //base case
        
        if(size == 0 || size == 1){
            return true; 
        }
        
        // processing
        
        if(arr[size - 1] < arr[size - 2]){
            return false;
        } 
        
        // recursive call 
        return isSorted(arr, size - 1);
    }
    
	public static void main(String[] args) {
	    
	    int[] arr = {45, 674, 34, 65, 4, 56};

//        int[] arr = {0, 1, 2, 3, 4, 5};
	    int size = 6;
	    
	    boolean ans = isSorted(arr, size);
	    
	    if(ans){
	        System.out.println("Array Is Sorted");
	    } else {
	        System.out.println("Array Is Not Sorted");
	    }

	}
}
