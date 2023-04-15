import java.util.*;

class PrintCounting{
    
    static void PrintCount(int n){
        
        // base case 
        
        if(n > 0){
            
            // recursive call 
            
           PrintCount(n-1);
           System.out.println(n);
        } 
        
        return;
    }
    
    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        PrintCount(n);
        
    }
}
