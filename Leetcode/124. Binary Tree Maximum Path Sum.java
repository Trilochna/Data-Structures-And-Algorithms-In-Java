/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = {root.val};
        dfs(root, result);
        return result[0];
    }

// maximum path sum without splitting recursively
    public int dfs(TreeNode root, int[] result){
        if(root == null){return 0;}
        // to avoid negative values
        int leftMax = Math.max(0, dfs(root.left, result));
        int rightMax = Math.max(0, dfs(root.right, result));
        // compute max path sum with split 
        // updating result to accquire max path sum
        result[0] = Math.max(result[0], leftMax + rightMax + root.val);
        // return value has to the max path sum without spliting
        return root.val + Math.max(leftMax, rightMax);
    }
}
