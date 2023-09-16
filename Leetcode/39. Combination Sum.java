class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        dfsBacktrack(result, 0, currCombination, 0, candidates, target);
        return result;
    }

    public void dfsBacktrack(List<List<Integer>> result, int i, List<Integer> currCombination, int sum, int[] candidates, int target){
        if(sum == target){
            result.add(new ArrayList<>(currCombination));
        } else if(i >= candidates.length || sum > target){
            return;
        }else{
            currCombination.add(candidates[i]);
            dfsBacktrack(result, i, currCombination, sum + candidates[i], candidates, target);
            currCombination.remove(currCombination.get(currCombination.size() - 1));
            dfsBacktrack(result, i + 1, currCombination, sum, candidates, target);
        }

    }
}
