class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, int index){
        if(index == nums.length){ // base case
            List<Integer> subst = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                subst.add(nums[i]); //  to create a copy of the current permutation list
            }
            result.add(subst);
            return;
        }

        for(int i = index; i < nums.length; i++){
            swap(nums, index, i);
            helper(result, nums, index + 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int index, int i){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
