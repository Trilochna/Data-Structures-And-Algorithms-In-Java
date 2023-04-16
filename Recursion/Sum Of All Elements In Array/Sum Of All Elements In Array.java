public class Main
{
    
    static int arrSum(int[] arr, int size){
        
        // base case:
        
        if(size <= 0){
            return 0;
        }
        
        // recursive relation
        
        return arrSum(arr, size - 1) + arr[size - 1];
    }
    
	public static void main(String[] args) {
	    
	    int size = 5;
	    int[] arr = {34, 45, 23, 67, 87};
	    
	    
		System.out.println(arrSum(arr, size));
	}
}
