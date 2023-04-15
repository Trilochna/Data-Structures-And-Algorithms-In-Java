import java.util.*;

class ReachDestination{
    
    static void ReachDest(int source, int destination){
        
        System.out.println("Source : " + source + "Destination : " + destination);
        
        // base case 
        
        if(source == destination){
            System.out.println("REACHED");
            return;
        } 
        
        // processing - ek agge badhane k liye
        
        source++;

        // recursive call
        ReachDest(source, destination);

    }
    
    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        
        int source = scn.nextInt();
        int destination = scn.nextInt();

        ReachDest(source, destination);
    }
}
