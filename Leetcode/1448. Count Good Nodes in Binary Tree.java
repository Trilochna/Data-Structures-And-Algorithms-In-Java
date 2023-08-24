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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxValue){
        int result;

        if(root == null){
            return 0;
        }

        if(root.val >= maxValue){
            result = 1;

        }else{
            result = 0;
        }

        maxValue = Math.max(maxValue, root.val);
        result += dfs(root.left, maxValue);
        result += dfs(root.right, maxValue);

        return result;
    }
}
