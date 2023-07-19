public class Main
{
    int arr[] = new int[100];
    int size;
    
    Main(){
        arr[0] = -1;
        size = 0;
    }
    
    public void insert(int val){
        size = size + 1;
        int index = size;
        arr[index] = val;
        
        while(index > 1){
            
            int parent = index/2;
            
            if(arr[parent] < arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            } else {
                return;
            }
        }
        
    }
    
    public void print(){
        for(int i = 1; i <= size; i++){
            System.out.println(arr[i] + " ");
        }
    }
    
    
	public static void main(String[] args) {
	    
	    Main heap = new Main();
	    heap.insert(50);
	    heap.insert(55);
	    heap.insert(53);
	    heap.insert(52);
	    heap.insert(54);
	    heap.print();
	}
}
