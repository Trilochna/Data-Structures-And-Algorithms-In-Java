class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left  = 1;
        int right = 1;
        for(int pile : piles){
            right = Math.max(right, pile);
        }

        int result = right; // because we know that at least the max will be the max possible solution 
        // starting binary search
        while(left <= right){
            int K_mid = left + (right - left) / 2;
            // COUNT FOR THIS VALUE K HOW MANY HOURS KOKO Takes to eat bananas

            int hours = 0;

            // and go through every pile 

            for(int p : piles){
                // for piles p we have to calculate how many hours it took to eat
                // and we ahve to roun up the value to 1+ hour
                hours += Math.ceil((double)p / K_mid); // type cast double to int to avoid possible lossy conversion from double to int
            }

            if(hours <= h){
                result = Math.min(result, K_mid);
            // to update the binary search to look for more smaller k
                right = K_mid - 1;
            } else {            // if this wasn't true'
                left = K_mid + 1;
            }
        }
        return result; // Return the minimum integer k such that she can eat all the bananas within h hours.
    }
}
