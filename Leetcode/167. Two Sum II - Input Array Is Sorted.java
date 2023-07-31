class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a, num_b;

        while(a_pointer < b_pointer){
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];

            int sum = num_a + num_b;

            if(sum == target){
                break;
            }

            if(sum < target){
                a_pointer++;
                continue;
            }

            if(sum > target){
                b_pointer--;
            }
        }

        return new int[] {a_pointer + 1, b_pointer + 1};
    }
}
