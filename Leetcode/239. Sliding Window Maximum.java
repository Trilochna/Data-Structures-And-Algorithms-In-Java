class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        int left = 0;
        int right;

        Deque<Integer> deque = new ArrayDeque<>();

        for(right = 0; right < nums.length; right++){
            if(!deque.isEmpty() && deque.peekFirst() < right - k + 1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[right] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offer(right);

            if(right >= k - 1){
                output[left++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
