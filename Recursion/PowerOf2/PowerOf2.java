import java.util.*;

class PowerOf2 {
    
    static int PowerOfTwo(int n){
        
        // base case 
        
        if(n==0){
            return 1;
        }
        
        // recursive relation
        
        return 2*PowerOfTwo(n-1);
        
//        int small_problem = PowerOfTwo(n-1);
//        int big_problem = 2*PowerOfTwo(n-1);
        
//        return big_problem;
    }
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        System.out.println("Two to the Power : " + n);

        int ans = PowerOfTwo(n);
        
        System.out.println("After Power Computation : " + ans);
    }
}
