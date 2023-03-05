class Solution {
    public boolean canJump(int[] nums) {

        int N = nums.length;
        int max = nums[0];
        for(int i = 1; i < N; i++){
            if(i <= max){
                max = Math.max(max, i + nums[i]);
            }
        }
        if(max >= N - 1){
            return true;
        }
    return false;
    }
}
