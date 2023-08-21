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
    int result = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    public int dfs(TreeNode root){
        // base case
        if(root == null){
            return -1;
        }
        // recursively find the height of the left subtree
        int leftttt = 1 + dfs(root.left);
        int righttt = 1 + dfs(root.right);
        // Finding the diameter of the current root that we are traversing
        result = Math.max(result , (leftttt + righttt));

        // returning height of the current node running through the root node
        return Math.max(leftttt, righttt);
    }
}
