class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> prevMap = new HashMap<>(); // val : index

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int diff = target - n;
            if(prevMap.containsKey(diff)){
                return new int[] {prevMap.get(diff), i};
            }
            prevMap.put(n, i);
        }
        return new int[] {};
    }
}
