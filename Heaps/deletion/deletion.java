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
    
    public void delete(){
        if(size == 0){
            System.out.println("Empty Heap");
            return;
        } 
        
        //step 1 - putting last element into root node
        arr[1] = arr[size]; 
        
        //step 2 = removinf last element
        size--;
        
        //step 3 - take root node to its correct postiion 
        
        int i = 1;
        while(i < size){
            int leftnode = 2*i;
            int rightnode = 2*i + 1;
        
        
        if(leftnode < size && arr[i] < arr[leftnode]){
            int temp = arr[i];
            arr[i] = arr[leftnode];
            arr[leftnode] = temp;
            i = leftnode;
        } else if(rightnode < size && arr[i] < arr[rightnode]){
            int temp = arr[i];
            arr[i] = arr[rightnode];
            arr[rightnode] = temp;
            i = rightnode;
        } else {
            return;
        }
        }
        
    }
    
	public static void main(String[] args) {
	    
	    Main heap = new Main();
	    heap.insert(50);
	    heap.insert(55);
	    heap.insert(53);
	    heap.insert(54);
	    heap.insert(52);
	    heap.print();
	    
	    heap.delete();
	    
	    System.out.println("Delete function executing :");
	    heap.print();
	    
	}
}
