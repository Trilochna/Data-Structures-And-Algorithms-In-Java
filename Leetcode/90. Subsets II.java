class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // helps pointers in skipping duplicates
        List<List<Integer>> result = new ArrayList<>(); // to add all our subsets
        List<Integer> subst = new ArrayList<>();
        backtrackingHelper(result, nums, 0, subst);
        return result;
    }

    public void backtrackingHelper(List<List<Integer>> result, int[] nums, int index, List<Integer> subst){
        if(index == nums.length){
            result.add(new ArrayList<>(subst));
            return;
        }
        // ALL SUBSETS THAT INCLUDE nums[index]
        subst.add(nums[index]);
        backtrackingHelper(result, nums, index + 1, subst);
        subst.remove(subst.size() - 1);
        // ALL SUBSETS THAT DON'T INCLUDE nums[index]
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){ // here in this loop we are comparing if 2 adjacent values are equal or not is they are equal then the loop will help to skip it and just to next value until we reach to the end of the array different values to add in subset encounters
            index++; // increments pointer to skip duplicate values until encounter different value
        } // loop terminates and give empty subset is no duplicate or eliminate duplicate values accordingly
        backtrackingHelper(result, nums, index + 1, subst);
    }
}
