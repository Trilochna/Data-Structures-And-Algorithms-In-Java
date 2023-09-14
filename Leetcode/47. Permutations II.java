class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){ // for incrementing count of numbers occuring/duplicates
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        dfsBacktrack(result, nums, perm, count);
        return result;
    }

    public void dfsBacktrack(List<List<Integer>> result, int[] nums, List<Integer> perm, HashMap<Integer, Integer> count){
        if(perm.size() == nums.length){ // means no more numbers are left to choose to for permutaion
            result.add(new ArrayList<>(perm));
            return;
        }

        for(int n : count.keySet()){
            if(count.get(n) > 0){
                perm.add(n);
                count.put(n, count.get(n) - 1); // for decrementing the value used
                dfsBacktrack(result, nums, perm, count);
                count.put(n, count.get(n) + 1); // for incrementing the count again after each iteration
                perm.remove(perm.size() - 1);
            }
        }
    }
}
