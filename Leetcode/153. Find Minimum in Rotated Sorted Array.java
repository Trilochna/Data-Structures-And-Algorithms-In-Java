class Solution {
    public int findMin(int[] nums) {
        int result = nums[0];

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] <= nums[right]){ // when already got a sorted sub array
                result = Math.min(result, nums[left]);
                break;
            }
            // if it is not sorted when we would actually want to do binary search
            int mid = left + (right - left)/2;

            result = Math.min(result, nums[mid]);

            // now wew want to know if we want to search miin element in the right or the left
// check if the mis is the part of the left sorted portion
// because if it is true then it rotated array would be having only max number on the left
// then we will have to search to the right for the smallest number
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
