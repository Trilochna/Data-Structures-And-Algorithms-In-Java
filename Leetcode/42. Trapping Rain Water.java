class Solution { // linear time and constant memory complexity solution
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        int result = 0;

        while(left < right){
            if(maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            } else  {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }

        return result;
    }
}

// 2nd approach:

// class Solution {
//   public int trap(int[] height) {
//     final int n = height.length;
//     int ans = 0;
//     int[] l = new int[n]; // l[i] := max(height[0..i])
//     int[] r = new int[n]; // r[i] := max(height[i..n))

//     for (int i = 0; i < n; ++i)
//       l[i] = i == 0 ? height[i] : Math.max(height[i], l[i - 1]);

//     for (int i = n - 1; i >= 0; --i)
//       r[i] = i == n - 1 ? height[i] : Math.max(height[i], r[i + 1]);

//     for (int i = 0; i < n; ++i)
//       ans += Math.min(l[i], r[i]) - height[i];

//     return ans;
//   }
// }
