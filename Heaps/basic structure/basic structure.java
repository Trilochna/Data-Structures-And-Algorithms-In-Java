public class Main
{
    
    private int[] Heap;
    private int size;
    private int maxsize;
    
    public Main(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }
    
    private int parent(int i){
        return(2*i) + 1;
    }
    
    private int leftChild(int i){
        return(i - 1) / 2;
    }
    
    private int rightChild(int i){
        return(2*i) + 2;
    }
    
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
	}
}
