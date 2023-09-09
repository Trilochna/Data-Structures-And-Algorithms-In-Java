class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // to add the subsets
        List<Integer> subst = new ArrayList<>(); // subset we currently have or working on
        helper(result, nums, 0, subst); // calling backtracking function
        return result; // pushing output of our answer
    }
    // index is the variable for the place where we are making our decision on
    // for each seperate individual subset we will name another list named subst 
    public void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> subst){
        // base case
        if(index >= nums.length){ 
            result.add(new ArrayList<>(subst)); // because we know with each iteration our subset is going to be updated so we will save a copy of that subst list in the result and move forward.
            return; // we are either at the end or have passed the leaf node 
        } else{
                    // add the element and start the  recursive call
            // decision to include nums[i]
            // left side of decision tree
            subst.add(nums[index]);
            // recursively use DFS on the next element to complete the left branch
            helper(result, nums, index + 1, subst); // contain included elements subsets
                    // remove the element and do the backtracking call.
            // decision not to include nums[i] i.e skipping nums[i]
            // right side of decision tree
            subst.remove(subst.size() - 1); // we will take the element we just added and pop it
            // recursively use DFS on the next element to complete the right branch
            helper(result, nums, index + 1, subst); // contain left/empty/not included elemnts subsets
        }
    }
}
