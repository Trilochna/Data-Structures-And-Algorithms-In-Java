class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();
        helper(result, candidates, target, currComb, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] candidates, int target, List<Integer> currComb, int index){
        if(target == 0){
            result.add(new ArrayList<>(currComb));
        } else if(target < 0){
            return;
        } else{
            for(int i = index; i < candidates.length; i++){
                // for avoiding duplicate numbers
                if(i > index && candidates[i] == candidates[i - 1]){
                    continue;
                }
                currComb.add(candidates[i]);
                // when we are choosing some candidaate at left
                helper(result, candidates, target - candidates[i], currComb, i + 1); // call for left branch
                // remove the number that we just added to the combination
                currComb.remove(currComb.get(currComb.size() - 1));
            }
        }
    }
}
