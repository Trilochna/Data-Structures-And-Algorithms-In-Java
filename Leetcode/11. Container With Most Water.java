class Solution {
    public int maxArea(int[] height) {
        int result  = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, area);

            if(height[left] < height[right]){
                left++;
            } else{
                // (height[right] < height[left] || height[right] == height[left])
                right--;
            }
        }

        return result;
    }
}
