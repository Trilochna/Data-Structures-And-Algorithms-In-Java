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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }

    public Pair<Boolean, Integer> dfs(TreeNode root){
        // base case
        if(root == null){ return new Pair<Boolean, Integer>(true, 0);}
        // recursive call
        var left = dfs(root.left);
        var right = dfs(root.right);
        // formula - function
        var balanced = left.getKey() && right.getKey() && (Math.abs(left.getValue() - right.getValue()) <= 1);
        return new Pair<Boolean, Integer>(balanced, 1 + Math.max(left.getValue(), right.getValue()));
    }
}
