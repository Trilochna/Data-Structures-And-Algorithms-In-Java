class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int a = nums[i];

            if(i > 0 && a == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int threeSum = a + nums[left] + nums[right];

                if(threeSum > 0){
                    right--;
                } else if(threeSum < 0){
                    left++;
                } else {

                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    result.add(temp);

                    left++;

                    while(nums[left] == nums[left - 1] && left < right){
                        left++;
                    }
                }


            }

        }

        return result;
        
    }
}


// ======================================= 2nd approach

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         // Sort the input array in ascending order
//         Arrays.sort(nums);

//         // Create a linked list to store the solutions
//         LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>();

//         // Loop through the array from the beginning
//         for (int i = 0; i < nums.length - 2; i++) {
//             // Skip duplicates to avoid duplicate triplets in the result
//             if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
//                 // Calculate the target value for the triplet
//                 int target = 0 - nums[i];
//                 int left = i + 1; // Pointer to the element next to nums[i]
//                 int right = nums.length - 1; // Pointer to the last element in the array

//                 // Use two-pointer technique to find the triplet
//                 while (left < right) {
//                     // If the sum of the two elements equals the target, we found a triplet
//                     if (nums[left] + nums[right] == target) {
//                         // Create a list to store the triplet and add it to the result
//                         ArrayList<Integer> miniSol = new ArrayList<>();
//                         miniSol.add(nums[i]);
//                         miniSol.add(nums[left]);
//                         miniSol.add(nums[right]);
//                         sol.add(miniSol);

//                         // Skip any duplicate elements to avoid duplicate triplets
//                         while (left < right && nums[left] == nums[left + 1]) {
//                             left++;
//                         }
//                         while (left < right && nums[right] == nums[right - 1]) {
//                             right--;
//                         }

//                         // Move the pointers to explore other possibilities
//                         left++;
//                         right--;
//                     } else if (nums[left] + nums[right] > target) {
//                         // If the sum is greater than the target, move the right pointer to the left
//                         right--;
//                     } else {
//                         // If the sum is less than the target, move the left pointer to the right
//                         left++;
//                     }
//                 }
//             }
//         }

//         // Return the list of triplets
//         return sol;
//     }
// }
