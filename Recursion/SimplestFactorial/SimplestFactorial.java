import java.util.*;

class Factorial {
    
    static int factorial(int n){
        
        if(n==0){
            return 1;
        }
        
        return n*factorial(n-1);
        
//        int choti_problem = factorial(n-1);
//        int badi_problem = n*factorial(n-1);
        
//        return badi_problem;
    }
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        System.out.println("NUMBER IS : " + n);

        int ans = factorial(n);
        
        System.out.println("FACTORIAL IS : " + ans);
    }
}
