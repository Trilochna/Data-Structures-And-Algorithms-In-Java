import java.util.* ;
import java.io.*; 
public class Solution
{
    public static void heapify(int arr[], int n, int i){
        int smallest_node = i;
        int left_node = 2*i + 1;
        int right_node = 2*i + 2;
        
        if(left_node < n && arr[smallest_node] > arr[left_node]){
            smallest_node = left_node;
        }
        
        if(right_node < n && arr[smallest_node] > arr[right_node]){
            smallest_node = right_node;
        }
        
        if(smallest_node != i){
            int temp =  arr[smallest_node];
            arr[smallest_node] = arr[i];
            arr[i] = temp;
            
            heapify(arr, n, smallest_node);
            
        }
    }

	public static int[] buildMinHeap(int[] arr)
	{
		// Write your code here

		int n = arr.length;
	    for(int i = (n/2)-1; i >= 0; i--){
	        heapify(arr, n, i);
	    }
		return arr;
	}
}

