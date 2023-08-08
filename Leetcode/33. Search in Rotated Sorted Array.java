class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){ // because if there is only one element in that array so we have to check that value too
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){return mid;}
            // check if we are in the left sorted portion
            if(nums[left] <= nums[mid]){
                if(target > nums[mid] || target < nums[left]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                // if we are in the right sorted portion of the array
            } else{
                if(target < nums[mid] || target > nums[right]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}




// class Solution {
//     public int search(int[] nums, int target) {
//         int left = 0;
//         int right = nums.length - 1;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (nums[mid] == target) {
//                 return mid;
//             }

//             if (nums[left] <= nums[mid]) {
//                 if (target >= nums[left] && target < nums[mid]) {
//                     right = mid - 1; 
//                 } else {
//                     left = mid + 1; 
//                 }
//             }
//             else {
//                 if (target > nums[mid] && target <= nums[right]) {
//                     left = mid + 1; 
//                 } else {
//                     right = mid - 1; 
//                 }
//             }
//         }

//         return -1; 
//     }
// }
