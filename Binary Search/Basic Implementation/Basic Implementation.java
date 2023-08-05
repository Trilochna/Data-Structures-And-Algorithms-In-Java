class BinarySearch {
    
    public static int binarySearching(int arr[], int size, int key){
        int start = 0;
        int end = size - 1;
        
        int mid = (start + end) / 2;
        // for optimization we can use the following function so that it will never go out of range : 

        // int mid = start + (end - start)/2;
         
        while(start <= end){
            if(arr[mid] == key){
                return mid;
            }
            // so to right part
            if(key > arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1; // go to left part
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arrEven = {2, 4, 6, 8, 12, 18};
        int[] arrOdd = {3, 8, 11, 14, 16};
        
        int evenIndex = binarySearching(arrEven, 6, 12);
        System.out.println("Index of Key 12 is : " + evenIndex);
        
        int oddIndex = binarySearching(arrOdd, 5, 14);
        System.out.println("Index of Key 14 is : " + oddIndex);
        
        int noKeyIndex = binarySearching(arrEven, 6, 120);
        System.out.println("Index of Key is : " + noKeyIndex);

    }
}
