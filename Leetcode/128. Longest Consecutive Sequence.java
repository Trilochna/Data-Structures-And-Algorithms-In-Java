class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet();
        int longest = 1;

        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            // check if it is the start of the sequence 
            // if index at left is empty and does'nt contain any value 
            // then it is the start of the sequence

            // if set doesn't contain n-1 = no left partner
            // then it is the start of that sequence'
            if(!set.contains(num - 1)){

                int count = 1;

                // for current value
                while(set.contains(num + 1)){
                    num++;
                    count++;
                }

        //check is=f the current is longest or the longest got previously is longest

                longest = Math.max(count, longest);


            }
        }

        // return the Longest Consecutive Sequence

        return longest;

    }
}
